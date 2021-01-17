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
    public void setUp(){
        account= new Account(transactionRepository);
    }

    @Test
    public void save_desposit_transaction_Test() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }
    @Test
    public void withdraw_transaction_Test(){
        account.withdraw(100);
        verify(transactionRepository).withdraw(100);
    }
}
