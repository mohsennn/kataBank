package com.kataBank.adservio.kataBank;

import java.util.List;

public class StatementPrinter {
    private Display display;

    public StatementPrinter(Display display) {
        this.display = display;
    }

    public void print(List<Transaction> transactions) {
        display.printLine("DATE | AMOUNT | BALANCE");
    }
}
