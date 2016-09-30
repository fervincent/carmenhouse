package com.pillinuma.entries;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by fernando on 9/29/16.
 */
public class EntryTest {

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

}
