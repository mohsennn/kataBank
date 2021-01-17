package com.kataBank.adservio.kataBank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PrintStatement {

    @Mock
    Display display;

    @Test
    public void print_statement_with_All_transaction() {
        account.deposit(700);
        account.withdraw(100);
        account.deposit(300);
        account.printStatement();

        verify(display).printLine("DATE | AMOUNT | BALANCE");
        verify(display).printLine("17/01/2021 | 300.00 | 900.00");
        verify(display).printLine("16/01/2021 | -100.00 | 600.00");
        verify(display).printLine("15/01/2021 | 700.00 | 700.00");
    }

}
