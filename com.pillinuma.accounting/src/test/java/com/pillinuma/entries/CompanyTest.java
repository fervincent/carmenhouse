package com.pillinuma.entries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class CompanyTest {

    @Test
    public void itShouldHaveConstructor() {
        Company company = new Company("MyCompany");
        assertEquals("MyCompany", company.getName());
    }
}
