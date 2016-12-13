package com.pillinuma.entries;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
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
                new Transaction("Give in the third floor", new BigDecimal("1")),
                new Transaction("Give in the third floor by the daughter", new BigDecimal("2"))
        );
        repository.addTransaction(transactions.get(0));
        repository.addTransaction(transactions.get(1));
        assertEquals(transactions, repository.getTransactions() );
    }

    @Test
    public void itShouldHaveCustomers() {
        List<Customer> fixedCustomers = Arrays.asList(
            new Customer("name1", "234", "Av dir"),
            new Customer("name2", "567", "Av dir 2")
        );
        repository.addCustomer(fixedCustomers.get(0));
        repository.addCustomer(fixedCustomers.get(1));
        assertEquals(fixedCustomers, repository.getCustomers());
    }

    @Test
    public void itShouldHaveReceipts() {
        Customer customer = new Customer("name1", "234", "Av dir");
        List<Receipt> fixedReceipts = Arrays.asList(
                new Receipt(1, customer, LocalDate.of(2016, 10, 28), company)
        );
        repository.addReceipt(fixedReceipts.get(0));

        assertEquals(fixedReceipts, repository.getReceipts());
    }




}
