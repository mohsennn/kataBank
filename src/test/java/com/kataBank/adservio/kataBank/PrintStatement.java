package com.kataBank.adservio.kataBank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PrintStatement {

    @Mock
    Display display;
    private Account account;
   @Mock
   TransactionDate transactionDate;

    @Before
    public void setUp() {
        TransactionRepository transactionRepository = new TransactionRepository(transactionDate);
        StatementPrinter statementPrinter = new StatementPrinter(display);
        account = new Account(transactionRepository,statementPrinter);
    }

    @Test
    public void print_statement_with_All_transaction() {
        account.deposit(700);
        account.withdraw(100);
        account.deposit(300);
        account.printStatement();
        InOrder inOrder = inOrder(display);

        inOrder.verify(display).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(display).printLine("17/01/2021 | 300.00 | 900.00");
        inOrder.verify(display).printLine("16/01/2021 | -100.00 | 600.00");
        inOrder.verify(display).printLine("15/01/2021 | 700.00 | 700.00");
    }

}
