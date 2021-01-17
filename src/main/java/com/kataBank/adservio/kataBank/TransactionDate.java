package com.kataBank.adservio.kataBank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionDate {

    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String dateAsString() {
       return today().format(dateFormatter);
    }
    protected LocalDate today() {
        return LocalDate.now();
    }
}
