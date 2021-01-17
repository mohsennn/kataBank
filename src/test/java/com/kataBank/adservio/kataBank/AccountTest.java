package com.kataBank.adservio.kataBank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void setUp() {
        account = new Account(transactionRepository,statementPrinter);
    }

    @Test
    public void save_desposit_transaction_Test() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void withdraw_transaction_Test() {
        account.withdraw(100);
        verify(transactionRepository).withdraw(100);
    }

    @Test
    public void printStatement() {
        List<Transaction> transactions = asList(new Transaction("17/01/2021",100));
        given(transactionRepository.allTransactions()).willReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);
    }
}
