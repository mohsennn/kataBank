package com.kataBank.adservio.kataBank;

import java.util.ArrayList;
 import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {

    private final TransactionDate transactionDate;
    private List<Transaction> transactions= new ArrayList<>();

    public TransactionRepository(TransactionDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void addDeposit(int amount) {
    Transaction depositTransaction = new Transaction(transactionDate.dateAsString(),amount);
    transactions.add(depositTransaction);
    }
    public void withdraw(int amount) {
        Transaction withdrawal = new Transaction(transactionDate.dateAsString(),-amount);
        transactions.add(withdrawal);
    }
    public List<Transaction> allTransactions(){
        return unmodifiableList(transactions);
    }
}
