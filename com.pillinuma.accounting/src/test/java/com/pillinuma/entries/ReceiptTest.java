package com.pillinuma.entries;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class ReceiptTest {
    Customer customer;
    @Before
    public void init() {
        customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");
    }

    @Test
    public void itShouldHaveConstructor() {

        Receipt receipt = new Receipt(1, customer);
        assertEquals(customer, receipt.getCustomer());
        assertEquals(1, receipt.getNumber());
    }

}
