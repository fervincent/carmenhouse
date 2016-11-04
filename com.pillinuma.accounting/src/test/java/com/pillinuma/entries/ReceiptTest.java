package com.pillinuma.entries;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class ReceiptTest {
    Customer customer;
    Company company;
    @Before
    public void init() {
        customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");
        company = new Company("Operadora del Sur");
        company.setAddress("Av Juan de Dios Morales");

    }

    @Test
    public void itShouldHaveConstructor() {

        Receipt receipt = new Receipt(1, customer, LocalDate.of(2016, 10, 06),
                company);
        assertEquals(customer, receipt.getCustomer());
        assertEquals(1, receipt.getNumber());
        assertEquals(LocalDate.of(2016, 10, 06), receipt.getIssuedDate());
        assertEquals(company, receipt.getCompany());
    }

    @Test
    public void itShouldAddEntries() {
        Receipt receipt = new Receipt(1, customer, LocalDate.of(2016, 10, 06),
                company);
        List<Entry> fixedEntries = Arrays.asList(
                new Entry("Entry1", new BigDecimal("100.00"), LocalDate.of(2016, 05, 06))
        );
        receipt.addEntry(fixedEntries.get(0));

        assertEquals(fixedEntries, receipt.getEntries());
    }

    @Test
    public void itShouldInheritFromBaseBO() {
        BaseBO baseBO = new Receipt(1, customer, LocalDate.of(2016, 10, 06),
                company);

    }



}
