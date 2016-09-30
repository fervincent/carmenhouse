package com.pillinuma.entries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fernando on 9/29/16.
 */
public class TagTest {

    @Test
    public void itShouldHaveProperties(){

        Tag tag = new Tag();

        tag.setName("Label1");
        assertEquals("Label1", tag.getName());

        tag.setOperator(Operator.ADD);
        assertEquals(Operator.ADD, tag.getOperator());
    }
}
