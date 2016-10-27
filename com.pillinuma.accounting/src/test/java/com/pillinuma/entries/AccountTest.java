package com.pillinuma.entries;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fabad on 26/10/2016.
 */
public class AccountTest {

    @Test
    public void itShouldHaveProperties() {
        Account account = new Account("vehicle2");
        assertEquals("vehicle2", account.getName());
        assertNotNull(account);


    }

    @Test
    public void itShouldAddCredit() {
        List<Entry> debitsFixed = Arrays.asList(
                new Entry("Desc 1", new BigDecimal("100.02"), LocalDate.of(2016, 06, 10)),
                new Entry("Desc 2", new BigDecimal("200.02"), LocalDate.of(2016, 06, 20))

        );
        Account account = new Account("vehicle 1");
        account.addDebit(debitsFixed.get(0));
        account.addDebit(debitsFixed.get(1));

        List<Entry> debits = account.getDebits();
        assertEquals(debitsFixed.size(), debits.size());
        assertEquals(debitsFixed, debits);


    }

    @Test
    public void itShouldAddDebit() {
        List<Entry> creditsFixed = Arrays.asList(
                new Entry("Entry 1", new BigDecimal("100.02"), LocalDate.of(2016, 06, 10)),
                new Entry("Entry 1", new BigDecimal("200.02"), LocalDate.of(2016, 06, 20))

        );
        Account account = new Account("salary");
        account.addCredit(creditsFixed.get(0));
        account.addCredit(creditsFixed.get(1));

        List<Entry> credits = account.getCredits();
        assertEquals(2, credits.size());
        assertEquals(creditsFixed, credits);


    }

    @Test (expected = UnsupportedOperationException.class )
    public void itShouldReadOnlyCredits() {

        Account account = new Account("salary");
        account.getCredits().add(new Entry("desc 1", new BigDecimal("100.00"), LocalDate.of(2016, 10, 10)));
    }

    @Test (expected = UnsupportedOperationException.class )
    public void itShouldReadOnlyDebits() {

        Account account = new Account("salary");
        account.getDebits().add(new Entry("desc 1", new BigDecimal("100.00"), LocalDate.of(2016, 10, 10)));
    }

}
