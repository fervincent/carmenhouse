package com.pillinuma.accounting.montefort;

import com.pillinuma.entries.Company;
import com.pillinuma.entries.Customer;
import com.pillinuma.entries.Entry;
import com.pillinuma.entries.Receipt;
import com.pillinuma.entries.Repository;
import com.pillinuma.entries.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by fabad on 27/10/2016.
 */
public class MontefortAccounting extends Repository{

    public MontefortAccounting() {
        super(new Company("Conjunto Montefort"));
        getCompany().setAddress("Avenida Eloy Alfaro y Pasaje de los Juncos N64-55");
        addCustomers();
        addTransactions();
        addReceipts();
        printReceipts();
    }

    protected void addCustomers() {
        addCustomer(new Customer("Piedad Torres", "1711995355", "APA-2B", "piedadtorres@hotmail.com"));
        addCustomer(new Customer("Wilmer Lomas", "1708901564", "APA-7F", "velascorovi@yahoo.com"));
    }

    protected void addTransactions() {
        Transaction transaction1 = new Transaction(new BigDecimal("1"));
        Entry entry = new Entry();
        entry.setDescription("Pago de servicios Luz/Agua mes de Septiembre. Pago realizado " +
                " en efectivo personalmente en el segundo piso");
        entry.setAmount(new BigDecimal("11.00"));
        entry.setDate(LocalDate.of(2016, 10, 29));
        transaction1.addEntry(entry);

        addTransaction(transaction1);
        Transaction transaction2  = new Transaction(new BigDecimal("2"));
        transaction2.addEntry(new Entry("Pago de medidor de agua interno y su correspondiente mano de obra para la instalación", new BigDecimal("100.00"),
                LocalDate.of(2016, 12, 12)));
        addTransaction(transaction2);

    }

    protected  void addReceipts() {
        Receipt receipt100 = new Receipt(100, getCustomers().get(0),
                LocalDate.of(2016, 10, 28), getCompany());
        receipt100.addEntry(getTransactions().get(0).getEntries().get(0));
        addReceipt(receipt100);

        Receipt receipt101 = new Receipt(101, getCustomers().get(1),
                LocalDate.of(2016, 12, 12), getCompany());
        receipt101.addEntry(getTransactions().get(1).getEntries().get(0));
        addReceipt(receipt101);

    }


}
