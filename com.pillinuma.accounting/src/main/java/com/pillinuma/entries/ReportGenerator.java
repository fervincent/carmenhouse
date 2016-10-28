package com.pillinuma.entries;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.collections.map.HashedMap;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by fabad on 27/10/2016.
 */
public class ReportGenerator {
    private Receipt receipt;

    public ReportGenerator(Receipt receipt) {
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public JRDataSource generateDataSourceReport() {
        System.out.println("entries:" + receipt.getEntries().size());
        return new JRBeanCollectionDataSource(receipt.getEntries());

    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("recipeNumber", receipt.getNumber());
        parameters.put("companyAddress", receipt.getCompany().getAddress());
        parameters.put("companyName", receipt.getCompany().getName());
        parameters.put("customerName", receipt.getCustomer().getName());
        parameters.put("customerIdentification", receipt.getCustomer().getIdentification());
        parameters.put("customerReference1", receipt.getCustomer().getReference1());

        Calendar issuedDate = Calendar.getInstance();

        issuedDate.set(Calendar.YEAR, receipt.getIssuedDate().getYear());
        issuedDate.set(Calendar.MONTH, receipt.getIssuedDate().getMonthValue() - 1);
        issuedDate.set(Calendar.DAY_OF_MONTH, receipt.getIssuedDate().getDayOfMonth());

        parameters.put("issuedDate", issuedDate.getTime());
        parameters.put("total", calculateTotal());
        parameters.put("entryds", generateDataSourceReport());
        Locale locale = new Locale("es", "EC");
        parameters.put(JRParameter.REPORT_LOCALE, locale);
        return parameters;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for(Entry entry: receipt.getEntries()) {
            total = total.add(entry.getAmount());
        }
        return total;
    }
}
