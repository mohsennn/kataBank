package com.kataBank.adservio.kataBank;

public class Account {

    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository= transactionRepository;
      }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
    }

    public void printStatement() {
    }
}
