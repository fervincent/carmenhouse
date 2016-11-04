package com.pillinuma.accounting.carmen;

import com.pillinuma.entries.Entry;
import com.pillinuma.entries.Repository;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by fabad on 02/11/2016.
 */
public class CarmenAccountingTest {

    CarmenAccounting carmenAccounting;

    @Before
    public void before() {
        carmenAccounting = new CarmenAccounting();

    }

    @Test
    public void itShouldHaveConstructor() {
        assertNotNull(carmenAccounting);
    }

    @Test
    public void itShouldInheritFromRepository() {
        Repository repository = carmenAccounting;
    }

    @Test
    public void itShouldPersist() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "carmen");





//Persist entities the way you are used to in plain JPA

        System.out.println("About to store dog and breed");
        //logger.info("About to store dog and breed");

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Entry entry = new Entry();
            entry.setDescription("Expensive test");
            entry.setAmount(new BigDecimal("100.2"));
            entry.setDate(LocalDate.of(2016, 10, 2));


            em.persist(entry);

            em.flush();
            //em.close();

            em.getTransaction().commit();
        }finally {
            if(em!=null) em.close();
            if(emf!=null) emf.close();
        }

    }

}
