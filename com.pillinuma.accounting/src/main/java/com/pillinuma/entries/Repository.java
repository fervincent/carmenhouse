package com.pillinuma.entries;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by fabad on 26/10/2016.
 */
public class Repository {

    private Company company;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<Customer> customers;
    private List<Receipt> receipts;

    public Repository(Company company) {
        this.company = company;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }

    public Company getCompany() {
        return company;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public List<Receipt> getReceipts() {
        return Collections.unmodifiableList(receipts);
    }

    protected void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public void printReceipts() {
        for(Receipt receipt: receipts) {
            printReceipt(receipt);
        }
    }
    protected  void printReceipt(Receipt receipt) {
        try {
            ReportGenerator reportGenerator = new ReportGenerator(receipt);


            JasperReport jasperReport = JasperCompileManager.compileReport("../reports/receipt.jrxml");
            /*JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    reportGenerator.getParameters(), new JREmptyDataSource());*/
            reportGenerator.generateDataSourceReport();
            //System.out.println(((JRDataSource)parameters.get("entryds")));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    reportGenerator.getParameters(), new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(jasperPrint, "build/recibo"+receipt.getNumber() + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
