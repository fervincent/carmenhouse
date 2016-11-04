package com.pillinuma.entries;

import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by fernando on 11/4/16.
 */
public class BaseTest {

    static EntityManagerFactory emf;
    static EntityManager em;

    @BeforeClass
    public static void before() {
        emf = Persistence.createEntityManagerFactory(
                "accounting");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        Entry entry = new Entry();
        entry.setDescription("Expensive test 1");
        entry.setAmount(new BigDecimal("200.25"));
        entry.setDate(LocalDate.of(2016, 10, 25));
        em.persist(entry);
        em.flush();
        em.getTransaction().commit();

    }

    @BeforeClass
    public static void after() {
        if(em!=null) em.close();
        if(emf!=null) emf.close();
    }
}
