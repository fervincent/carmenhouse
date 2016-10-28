package com.pillinuma.entries;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fabad on 27/10/2016.
 */
public class ReportGeneratorTest {

    private Receipt receipt;
    private Customer customer;
    private Company company;
    private List<Entry> entries;

    @Before
    public void before() {
        entries = Arrays.asList(
                new Entry("Desc1", new BigDecimal("2000.30"), LocalDate.of(2016,10, 20)),
                new Entry("Desc2", new BigDecimal("20056.30"), LocalDate.of(2016,11, 20))
        );
        company = new Company("Operadora del Sur");
        company.setAddress("Av Juan de Dios Morales");
        customer = new Customer("Jhon Varela", "1767568765", "Apartamento 2");
        receipt = new Receipt(1, customer, LocalDate.of(2016, 10, 06), company);
        receipt.addEntry(entries.get(0));
        receipt.addEntry(entries.get(1));
    }

    @Test
    public void itShouldHaveEmptyConstructor() {

        ReportGenerator reportGenerator = new ReportGenerator(receipt);
        assertEquals(receipt, reportGenerator.getReceipt());

    }

    @Test
    public void itShouldGenerateReportDataSource() {

        ReportGenerator reportGenerator = new ReportGenerator(receipt);
        JRDataSource jrDataSource = reportGenerator.generateDataSourceReport();
        assertNotNull(jrDataSource);
    }

    @Test
    public void itShouldCalculateTotal() {
        ReportGenerator reportGenerator = new ReportGenerator(receipt);
        assertEquals(new BigDecimal("22056.60"), reportGenerator.calculateTotal());

    }

    @Test
    public void itShouldGenerateParams() {
        ReportGenerator reportGenerator = new ReportGenerator(receipt);
        Map<String, Object> parameters = reportGenerator.getParameters();
        assertEquals(1, parameters.get("recipeNumber"));
        assertEquals("Av Juan de Dios Morales", parameters.get("companyAddress"));
        assertEquals("Operadora del Sur", parameters.get("companyName"));
        assertEquals("Jhon Varela", parameters.get("customerName"));
        assertEquals("1767568765", parameters.get("customerIdentification"));
        assertEquals("Apartamento 2", parameters.get("customerReference1"));
        Calendar issuedDate = Calendar.getInstance();
        LocalDate localDate = LocalDate.of(2016, 10, 06);
        issuedDate.set(Calendar.YEAR, localDate.getYear());
        issuedDate.set(Calendar.MONTH, localDate.getMonthValue() - 1);
        issuedDate.set(Calendar.DAY_OF_MONTH, localDate.getDayOfMonth());
        assertNotNull(parameters.get("issuedDate"));
        assertEquals(new BigDecimal("22056.60"), parameters.get("total"));
        assertNotNull(parameters.get("entryds"));
        //assertEquals( issuedDate.getTime(), parameters.get("issuedDate"));

    }

    @Test
    public void itShouldGeneratePdf() {
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
