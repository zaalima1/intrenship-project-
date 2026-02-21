<<<<<<< HEAD:src/main/java/com/example/siya/service/PdfStatementService.java
package com.example.siya.service;

import com.example.siya.entity.Transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

=======
package VaultCore_Financial.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import VaultCore_Financial.entity.Auditable;
import VaultCore_Financial.entity.Transaction;

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/PdfStatementService.java
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
<<<<<<< HEAD:src/main/java/com/example/siya/service/PdfStatementService.java
=======
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/PdfStatementService.java
import java.time.YearMonth;
import java.util.List;

@Service
public class PdfStatementService {
<<<<<<< HEAD:src/main/java/com/example/siya/service/PdfStatementService.java

    public ByteArrayInputStream generateMonthlyStatement(String accountNumber,
                                                         List<Transaction> transactions) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // ✅ Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Monthly Statement", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Account Number: " + accountNumber));
            document.add(new Paragraph("Month: " + YearMonth.now()));
            document.add(new Paragraph(" "));

            // ✅ Table
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            // Header row
            table.addCell("ID");
            table.addCell("From Account");
            table.addCell("To Account");
            table.addCell("Amount");
            table.addCell("Date");

            // Data rows
            for (Transaction txn : transactions) {

                table.addCell(String.valueOf(txn.getId())); // ✅ Correct field
                table.addCell(txn.getFromAccount());
                table.addCell(txn.getToAccount());
                table.addCell(String.valueOf(txn.getAmount()));
                table.addCell(String.valueOf(txn.getCreatedAt()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
=======
	 @Auditable(module = "PDF", action = "pdf_downloading")
	 public ByteArrayInputStream generateMonthlyStatement(String accountNumber, List<Transaction> transactions) {

		    // Filter transactions by accountNumber
		    List<Transaction> filteredTxns = transactions.stream()
		        .filter(txn -> accountNumber.equals(txn.getFromAccount()) || accountNumber.equals(txn.getToAccount()))
		        .toList(); // Java 16+ or use .collect(Collectors.toList()) for earlier versions

		    Document document = new Document();
		    ByteArrayOutputStream out = new ByteArrayOutputStream();

		    try {
		        PdfWriter.getInstance(document, out);
		        document.open();

		        // Title
		        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
		        Paragraph title = new Paragraph("Monthly Statement", titleFont);
		        title.setAlignment(Element.ALIGN_CENTER);
		        document.add(title);

		        document.add(new Paragraph(" "));
		        document.add(new Paragraph("Account Number: " + accountNumber));
		        document.add(new Paragraph("Month: " + YearMonth.now()));

		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		        String generatedDate = LocalDateTime.now().format(formatter);
		        document.add(new Paragraph("Statement Generated On: " + generatedDate));
		        document.add(new Paragraph(" "));

		        // Table
		        PdfPTable table = new PdfPTable(5);
		        table.setWidthPercentage(100);
		        table.addCell("Txn ID");
		        table.addCell("Date & Time");
		        table.addCell("From");
		        table.addCell("To");
		        table.addCell("Amount");

		        DateTimeFormatter txnFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		        for (Transaction txn : filteredTxns) {
		            table.addCell(txn.getTxnId());
		            String txnDate = (txn.getTimestamp() != null) ? txn.getTimestamp().format(txnFormatter) : "N/A";
		            table.addCell(txnDate);
		            table.addCell(txn.getFromAccount());
		            table.addCell(txn.getToAccount());
		            table.addCell("₹ " + txn.getAmount());
		        }

		        document.add(table);
		        document.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return new ByteArrayInputStream(out.toByteArray());
		}

    
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/PdfStatementService.java
}
