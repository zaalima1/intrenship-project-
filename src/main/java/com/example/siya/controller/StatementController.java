package com.example.siya.controller;

import com.example.siya.entity.Transaction;
import com.example.siya.repo.TransactionRepository;
import com.example.siya.service.PdfStatementService;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Controller
@RequestMapping("/statement")
public class StatementController {

    private final TransactionRepository transactionRepository;
    private final PdfStatementService pdfService;

    public StatementController(TransactionRepository transactionRepository,
                               PdfStatementService pdfService) {
        this.transactionRepository = transactionRepository;
        this.pdfService = pdfService;
    }

    // ✅ Show UI page
    @GetMapping("/page")
    public String showStatementPage() {
        return "statement";
    }

    // ✅ Download PDF
    @GetMapping("/download/{accountNumber}")
    public ResponseEntity<byte[]> downloadStatement(@PathVariable String accountNumber) {

        YearMonth currentMonth = YearMonth.now();
        LocalDateTime start = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime end = currentMonth.atEndOfMonth().atTime(23, 59, 59);

        List<Transaction> transactions =
                transactionRepository.findAllTransactions(accountNumber);

        System.out.println("Transactions Found: " + transactions.size());


        // 🔥 Debug (remove later)
        System.out.println("Transactions Found: " + transactions.size());

        ByteArrayInputStream pdf =
                pdfService.generateMonthlyStatement(accountNumber, transactions);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=Monthly_Statement_" + accountNumber + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }
}
