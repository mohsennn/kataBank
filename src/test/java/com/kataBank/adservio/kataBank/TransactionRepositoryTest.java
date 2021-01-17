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
    TransactionDtate transactionDtate;

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository(transactionDtate);
    }

    @Test
    public void deposit_Transaction_Test() {

        given(transactionDtate.dateAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}
