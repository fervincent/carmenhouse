package com.pillinuma.accounting.montefort;

import com.pillinuma.entries.Company;
import com.pillinuma.entries.Repository;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 27/10/2016.
 */
public class MontefortAccountingTest {
    MontefortAccounting montefortAccounting;
    @Before
    public void before() {
        montefortAccounting = new MontefortAccounting();
    }

    @Test
    public void itShouldHaveConstructor() {
        assertNotNull(montefortAccounting);
    }

    @Test
    public void itShouldLoadCompany() {
        assertNotNull(montefortAccounting.getCompany());
        assertNotNull(montefortAccounting.getCompany().getAddress());
    }

    @Test
    public void itShouldInheritFromRepository() {
        Repository mainstreetRepository = montefortAccounting;
    }

    @Test
    public void itShouldLoadCustomers() {
        assertTrue(montefortAccounting.getCustomers().size() > 0);
    }

    @Test
    public void itShouldLoadTransaction() {
        assertTrue(montefortAccounting.getTransactions().size() > 0);

    }

    @Test
    public void itShouldLoadRecipes () {
        assertTrue(montefortAccounting.getReceipts().size() > 0);
    }

    @Test
    public void itShouldPrintReceipts() {
        assertEquals(2, montefortAccounting.getReceipts().size());
        montefortAccounting.printReceipts();
    }


}
