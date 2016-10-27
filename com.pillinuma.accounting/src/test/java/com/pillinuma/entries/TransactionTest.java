package com.pillinuma.entries;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by fabad on 26/10/2016.
 */
public class TransactionTest {

    @Test
    public void itShouldHaveConstructor () {

        Entry entryDebitCar = new Entry("By a Car", new BigDecimal("30000"), LocalDate.of(2016,10,05));
        Entry entryCreditCar = new Entry("By a Car", new BigDecimal("30000"), LocalDate.of(2016,10,05));
        Transaction transaction = new Transaction(new BigDecimal("1"));

        assertEquals(new BigDecimal("1"), transaction.getNumber());

    }

    @Test
    public void itShouldHaveEntries () {
        List<Entry> fixedEntries = Arrays.asList(
                new Entry("By a Car", new BigDecimal("30000"), LocalDate.of(2016,10,05)),
                new Entry("By a Car", new BigDecimal("30000"), LocalDate.of(2016,10,05))
        );

        Transaction transaction = new Transaction(new BigDecimal("1"));
        transaction.addEntry(fixedEntries.get(0));
        transaction.addEntry(fixedEntries.get(1));

        assertEquals(fixedEntries, transaction.getEntries());
    }

}
