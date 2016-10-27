package com.pillinuma.entries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fabad on 26/10/2016.
 */
public class Receipt {
    private Customer customer;
    private int number;
    private LocalDate issuedDate;
    private List<Entry> entries;
    private Company company;

    public Receipt(int number, Customer customer, LocalDate issuedDate, Company company) {
        this.number = number;
        this.customer = customer;
        this.issuedDate = issuedDate;
        this.entries = new ArrayList<>();
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }
    public int getNumber() {
        return number;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public List<Entry> getEntries() {
        return Collections.unmodifiableList(entries);
    }


    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public Company getCompany() {
        return company;
    }
}
