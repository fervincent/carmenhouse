package com.pillinuma.entries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fernando on 9/29/16.
 */
public class OperatorTest {

    @Test
    public void itShouldHaveProperties() {

        Operator operator = Operator.ADD;
        assertEquals(Operator.ADD, operator);

        operator = Operator.MINUS;
        assertEquals(Operator.MINUS, operator);
    }
}
