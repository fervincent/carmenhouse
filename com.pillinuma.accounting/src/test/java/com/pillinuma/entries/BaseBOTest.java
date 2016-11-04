package com.pillinuma.entries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by fernando on 11/3/16.
 */
public class BaseBOTest {

    @Test
    public void itShouldHaveId() {
        BaseBO baseBO = new BaseBO();
        baseBO.setId("10");
        assertEquals("10", baseBO.getId());
    }
}
