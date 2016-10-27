package com.pillinuma.entries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by fabad on 26/10/2016.
 */
public class Account {

    private List<Entry> debits;
    private String name;
    private List<Entry> credits;

    public Account(String name) {
        this.name = name;
        debits = new ArrayList<>();
        credits = new ArrayList<>();
    }

    public void addDebit(Entry entry) {
        debits.add(entry);
    }


    public List<Entry> getDebits() {
        return Collections.unmodifiableList(debits);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entry> getCredits() {
        return Collections.unmodifiableList(credits);
    }


    public void addCredit(Entry entry) {
        credits.add(entry);
    }
}
