package com.kataBank.adservio.kataBank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
    @Mock
    Display display;

    private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;

    @Test
    public void print_Test() {
        StatementPrinter statementPrinter = new StatementPrinter(display);
        statementPrinter.print(NO_TRANSACTIONS);
        verify(display).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_IN_REVERSE_ORDER_Test() {
        StatementPrinter statementPrinter = new StatementPrinter(display);

        List<Transaction> transactions = transactionsContaining(
                deposit("15/01/2021", 700),
                withdraw("16/01/2021", 100),
                deposit("17/01/2021", 300));

        statementPrinter.print(transactions);
        InOrder inOrder = inOrder(display);

        inOrder.verify(display).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(display).printLine("17/01/2021 | 300.00 | 900.00");
        inOrder.verify(display).printLine("16/01/2021 | -100.00 | 600.00");
        inOrder.verify(display).printLine("15/01/2021 | 700.00 | 700.00");
    }

    private List<Transaction> transactionsContaining(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date, amount);
    }

    private Transaction withdraw(String date, int amount) {
        return new Transaction(date, -amount);
    }
}
