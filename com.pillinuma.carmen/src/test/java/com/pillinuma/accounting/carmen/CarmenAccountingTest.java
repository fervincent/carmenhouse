package com.pillinuma.accounting.carmen;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fabad on 02/11/2016.
 */
public class CarmenAccountingTest {

    @Test
    public void itShouldHaveConstructor() {
        CarmenAccounting carmenAccounting = new CarmenAccounting();
        assertNotNull(carmenAccounting);
    }
}
