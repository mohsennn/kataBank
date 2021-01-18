package com.kataBank.adservio.kataBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataBankApplication.class, args);
        TransactionDate transactionDate = new TransactionDate();
        TransactionRepository transactionRepository = new TransactionRepository(transactionDate);
        Display display = new Display();
        StatementPrinter statementPrinter = new StatementPrinter(display);
        Account account = new Account(transactionRepository, statementPrinter);
        account.deposit(700);
        account.withdraw(100);
        account.deposit(500);
        account.printStatement();
    }

}
