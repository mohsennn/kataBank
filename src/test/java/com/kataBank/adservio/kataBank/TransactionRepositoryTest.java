package com.kataBank.adservio.kataBank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    private static final String TODAY = "17/01/2021";
    private TransactionRepository transactionRepository;
    @Mock
    TransactionDate transactionDate;

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository(transactionDate);
        given(transactionDate.dateAsString()).willReturn(TODAY);
    }

    @Test
    public void deposit_Transaction_Test() {
        transactionRepository.addDeposit(100);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    @Test
    public void withdraw_Transaction_Test() {
        given(transactionDate.dateAsString()).willReturn(TODAY);
        transactionRepository.withdraw(100);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, -100)));
    }


    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}
