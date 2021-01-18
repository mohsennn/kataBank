package com.kataBank.adservio.kataBank;

import java.util.Objects;

public class Transaction {
    private final String date;
    private final int amount;

    public int amount() {
        return amount;
    }

    public String date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
