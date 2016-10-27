package com.pillinuma.entries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by fabad on 26/10/2016.
 */
public class Repository {

    private Company company;
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Repository(Company company) {
        this.company = company;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public Object getCompany() {
        return company;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
