package com.pillinuma.entries;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by fernando on 9/29/16.
 */
public class EntryTest extends BaseTest {


    @Test
    public void testItShouldHaveProperties() {
        Entry entry = new Entry();

        entry.setDescription("Money given to fervincent");
        assertNotNull(entry.getTags());
        assertEquals("Money given to fervincent", entry.getDescription());

        entry.setAmount(new BigDecimal("10.00"));
        assertEquals(new BigDecimal("10.00"), entry.getAmount());

        entry.setDate(LocalDate.of(2016, Month.SEPTEMBER, 27));
        assertEquals(LocalDate.of(2016, Month.SEPTEMBER, 27), entry.getDate());
        Map<String, Tag> tags = new HashMap<>();
        Tag tagLabel1 = new Tag();
        tagLabel1.setName("Label1");
        tags.put(tagLabel1.getName(), tagLabel1);
        entry.setTags(tags);
        assertEquals(1, entry.getTags().size());
        System.out.println("hola");

    }

    @Test
    public void itShouldHaveTags(){
        Entry entry = new Entry();
        Tag tag = new Tag();

        tag.setName("house1");
        entry.addTag(tag);
        Tag tmpTag = entry.getTag("house1");
        assertEquals("house1", tmpTag.getName());
        assertNull(entry.getTag("labeltmp"));
    }

    @Test
    public void itShouldHaveConstructorWithNotNullProperties() {
        Entry entry = new Entry("Desc 1", new BigDecimal("100.02"),
                LocalDate.of(2016, 06, 10));
        assertEquals("Desc 1", entry.getDescription());
        assertEquals(new BigDecimal("100.02"), entry.getAmount());
        assertEquals(LocalDate.of(2016, 06, 10), entry.getDate());
    }

    @Test
    public void itShouldInheritFromBaseBO() {
        BaseBO baseBO = new Entry();
        baseBO.setId("1");
        assertEquals("1", baseBO.getId());
    }

    @Test
    public void itShouldPersist() {

        em.getTransaction().begin();
        Entry entry = new Entry();
        entry.setDescription("Expensive test");
        entry.setAmount(new BigDecimal("100.2"));
        entry.setDate(LocalDate.of(2016, 10, 2));
        em.persist(entry);
        em.flush();
        //em.close();

        em.getTransaction().commit();
        String entryId = entry.getId();

        em.getTransaction().begin();
        Entry entryFounded = em.find(Entry.class, entryId);
        System.out.println("Entry Founded" + entryFounded.getDescription()
                    + " " + entryFounded.getId());
        assertEquals("Expensive test", entryFounded.getDescription());
        assertEquals(LocalDate.of(2016, 10, 2), entryFounded.getDate());
        assertTrue(new BigDecimal("100.2").compareTo(entryFounded.getAmount())==0);

        em.flush();



        em.getTransaction().commit();


    }

    @Test
    public void itShouldFindByDate() {
        em.getTransaction().begin();
        TypedQuery<Entry> query = em.createNamedQuery("Entry.findByDate", Entry.class);
        query.setParameter("date", LocalDate.of(2016, 10, 25));
        Entry entryFounded = query.getSingleResult();
        assertEquals("Expensive test 1", entryFounded.getDescription());

        em.getTransaction().commit();
    }

    @Test
    public void itShouldFindByAmount() {
        em.getTransaction().begin();
        TypedQuery<Entry> query = em.createNamedQuery("Entry.findByAmount", Entry.class);
        query.setParameter("amount", new BigDecimal("200.250"));
        Entry entryFounded = query.getSingleResult();
        assertEquals("Expensive test 1", entryFounded.getDescription());


        em.getTransaction().commit();
    }

}
