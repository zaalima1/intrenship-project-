package com.example.siya.service;

import com.example.siya.entity.Transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.YearMonth;
import java.util.List;

@Service
public class PdfStatementService {

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
}
