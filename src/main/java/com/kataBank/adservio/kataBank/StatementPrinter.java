package com.kataBank.adservio.kataBank;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    private Display display;
    public static final String HEADER = "DATE | AMOUNT | BALANCE";
    private DecimalFormat decimalFormatter = new DecimalFormat("#,00");

    public StatementPrinter(Display display) {
        this.display = display;
    }

    public void print(List<Transaction> transactions) {
        display.display(HEADER);
        printStatement(transactions);
    }

    private void printStatement(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> displaytransaction(transaction, runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(display::display);
    }

    private String displaytransaction(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.date()
                + " | "
                + decimalFormatter.format(transaction.amount())
                + " | "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));
    }
}
