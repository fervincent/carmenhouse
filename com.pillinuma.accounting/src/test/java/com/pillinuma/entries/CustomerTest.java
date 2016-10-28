package com.pillinuma.entries;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class CustomerTest {

    @Test
    public void itShouldHaveConstructor() {
        Customer customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");
        assertEquals("Jhon Varela", customer.getName());
        assertEquals("1767568765", customer.getIdentification());
        assertEquals("Apartamento 2", customer.getReference1());
    }

    @Test
    public void itShouldHaveEmail() {
        Customer customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2",
                "jhon.varela@gmail.com");
        assertEquals("Jhon Varela", customer.getName());
        assertEquals("1767568765", customer.getIdentification());
        assertEquals("Apartamento 2", customer.getReference1());
        assertEquals("jhon.varela@gmail.com", customer.getEmail());

    }

}
