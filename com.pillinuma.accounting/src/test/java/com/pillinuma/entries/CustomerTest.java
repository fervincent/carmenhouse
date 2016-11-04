package com.pillinuma.entries;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class CustomerTest extends BaseTest {

    @Test
    public void itShouldHaveConstructor() {
        Customer customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");
        assertEquals("Jhon Varela", customer.getName());
        assertEquals("1767568765", customer.getIdentification());
        assertEquals("Apartamento 2", customer.getReference1());
    }

    @Test
    public void itShouldHaveProperties() {
        Customer customer = new Customer();
        customer.setIdentification("1767568765");
        customer.setName("Jhon Varela");
        customer.setReference1("Apartamento 2");
        customer.setEmail("jhon.varela@gmail.com");

        assertEquals("Jhon Varela", customer.getName());
        assertEquals("1767568765", customer.getIdentification());
        assertEquals("Apartamento 2", customer.getReference1());
        assertEquals("jhon.varela@gmail.com", customer.getEmail());


    }

    @Test
    public void itShouldInheritFromBaseBO() {
        BaseBO baseBO = new Customer("Jhon Varela", "1767568765", "Apartamento 2",
                "jhon.varela@gmail.com");

    }

    @Test
    public void itShouldPersist() {
        em.getTransaction().begin();
        Customer customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");

        em.persist(customer);
        String id = customer.getId();
        em.flush();
        em.getTransaction().commit();
        em.getTransaction().begin();
        Customer foundedCustomer = em.find(Customer.class, id);
        assertEquals("Jhon Varela", foundedCustomer.getName());
        assertEquals("1767568765", foundedCustomer.getIdentification());
        assertEquals("Apartamento 2", foundedCustomer.getReference1());

        em.getTransaction().commit();

    }

}
