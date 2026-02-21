<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementController.java
package com.example.siya.controller;

import com.example.siya.entity.Transaction;
import com.example.siya.repo.TransactionRepository;
import com.example.siya.service.PdfStatementService;
=======
package VaultCore_Financial.controller;

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementController.java

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementController.java
=======
import VaultCore_Financial.entity.Transaction;
import VaultCore_Financial.repo.TransactionRepository;
import VaultCore_Financial.service.PdfStatementService;

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementController.java
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

<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementController.java
    // ✅ Download PDF
=======
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementController.java
    @GetMapping("/download/{accountNumber}")
    public ResponseEntity<byte[]> downloadStatement(@PathVariable String accountNumber) {

        YearMonth currentMonth = YearMonth.now();
        LocalDateTime start = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime end = currentMonth.atEndOfMonth().atTime(23, 59, 59);

        List<Transaction> transactions =
<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementController.java
                transactionRepository.findAllTransactions(accountNumber);

        System.out.println("Transactions Found: " + transactions.size());


        // 🔥 Debug (remove later)
        System.out.println("Transactions Found: " + transactions.size());
=======
                transactionRepository.findMonthlyTransactions(accountNumber, start, end);

        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this month");
        }
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementController.java

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
<<<<<<< HEAD:src/main/java/com/example/siya/controller/StatementController.java
=======

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/StatementController.java
}
