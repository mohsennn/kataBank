package com.kataBank.adservio.kataBank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock TransactionRepository transactionRepository;

    private Account account;

    @Before
    public void initialise(){
        account= new Account(transactionRepository);
    }

    @Test
    public void save_desposit_transaction() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }
}
