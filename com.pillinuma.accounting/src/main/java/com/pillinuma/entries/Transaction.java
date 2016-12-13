package com.pillinuma.entries;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabad on 26/10/2016.
 */
public class Transaction {

    private BigDecimal number;
    private List<Entry> entries;
    /**
     * place, hour, special signal to recognize the transaction
     */
    private String description;

    public Transaction(String description, BigDecimal number) {
        this.number = number;
        this.entries = new ArrayList<>();
        this.description = description;
    }


    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);

    }

    public List<Entry> getEntries() {
        return entries;
    }

    public String getDescription() {
        return description;
    }
}
