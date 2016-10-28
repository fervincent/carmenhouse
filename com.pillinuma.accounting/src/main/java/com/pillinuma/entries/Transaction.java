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

    public Transaction(BigDecimal number) {
        this.number = number;
        entries = new ArrayList<>();
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


}
