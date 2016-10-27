package com.pillinuma.entries;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class RepositoryTest {

    Repository repository;
    Company company;
    @Before
    public void init() {
        company = new Company("MyCompany");
        repository = new Repository(company);
    }

    @Test
    public void itShouldHaveConstructor() {
        assertEquals(company, repository.getCompany());
    }

    @Test
    public void itShouldHaveAccounts () {
        Account account = new Account("Account 1");
        repository.addAccount(account);
        List<Account> accounts = repository.getAccounts();
        assertEquals(account, accounts.get(0));

    }

    @Test (expected = UnsupportedOperationException.class)
    public void itShouldReturnReadOnlyAccounts() {
        Account account = new Account("Account 1");
        repository.addAccount(account);
        List<Account> accounts = repository.getAccounts();
        accounts.remove(0);

    }
    @Test
    public void itShouldHaveTransactions() {

        List<Transaction> transactions = Arrays.asList(
                new Transaction(new BigDecimal("1")),
                new Transaction(new BigDecimal("2"))
        );
        repository.addTransaction(transactions.get(0));
        repository.addTransaction(transactions.get(1));
        assertEquals(transactions, repository.getTransactions() );
    }





}
