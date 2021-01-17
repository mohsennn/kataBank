package com.kataBank.adservio.kataBank;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private final TransactionDtate transactionDtate;
    private List<Transaction> transactions= new ArrayList<>();

    public TransactionRepository(TransactionDtate transactionDtate) {
        this.transactionDtate=transactionDtate;
    }

    public void addDeposit(int amount) {
    Transaction depositTransaction = new Transaction(transactionDtate.dateAsString(),amount);
    transactions.add(depositTransaction);
    }
    public void withdraw(int amount) {
        throw new UnsupportedOperationException();
    }
    public List<Transaction> allTransactions(){
        throw new UnsupportedOperationException();
    }
}
