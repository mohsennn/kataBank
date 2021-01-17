package com.kataBank.adservio.kataBank;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TransactionDateTest {

    @Test
    public void dateAsString_Test(){
        TransactionDate  transactionDate= new GenericDateForTest();
        String date = transactionDate.dateAsString();
        LocalDate dateTime=LocalDate.now();
        assertThat(date,is("19/01/2021"));
    }
    private class GenericDateForTest extends TransactionDate{
        @Override
        protected LocalDate today(){
            return LocalDate.of(2021,01,19);
        }
    }

}
