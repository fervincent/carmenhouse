package com.pillinuma.accounting.carmen;


import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

/**
 * Created by fernando on 11/2/16.
 */
public class HibernateTest {

    @Test
    public void itShouldSave() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

//accessing JBoss's Transaction can be done differently but this one works nicely

//build the EntityManagerFactory as you would build in in Hibernate ORM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "carmen");





//Persist entities the way you are used to in plain JPA

        System.out.println("About to store dog and breed");
        //logger.info("About to store dog and breed");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Breed collie = new Breed();
        collie.setId("1");
        collie.setName("Collie");
        em.persist(collie);
        Dog dina = new Dog();
        dina.setId(2L);
        dina.setName("Dina");
        dina.setBreed(collie);
        em.persist(dina);
        Long dinaId = dina.getId();
        em.flush();
        //em.close();

        em.getTransaction().commit();
        //em.close();

//Retrieve your entities the way you are used to in plain JPA

        em.getTransaction().begin();
        System.out.println("About to retrieve dog and breed");
        //logger.info("About to retrieve dog and breed");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        dina = em.find(Dog.class, dinaId);
        //logger.info("Found dog %s of breed %s", dina.getName(), dina.getBreed().getName());
        System.out.println("Found dog %s of breed %s" + dina.getName()  + " " + dina.getBreed().getName());
        em.flush();



        em.getTransaction().commit();

        /*em.getTransaction().begin();
        em.createNativeQuery("SHUTDOWN").executeUpdate();
        em.getTransaction().commit();*/

        System.out.println("1");
        em.close();
        System.out.println("2");
        emf.close();
        System.out.println("3:" + emf.isOpen());

    }
}
