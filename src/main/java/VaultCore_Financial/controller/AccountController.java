<<<<<<< HEAD:src/main/java/com/example/siya/controller/AccountController.java
package com.example.siya.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.siya.entity.Account;
import com.example.siya.entity.Auditable;
import com.example.siya.repo.AccountRepository;
=======
package VaultCore_Financial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VaultCore_Financial.entity.Account;
import VaultCore_Financial.entity.Auditable;
import VaultCore_Financial.repo.AccountRepository;


>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AccountController.java

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository accountRepo;

    public AccountController(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @PostMapping("/create")
    @Auditable(module = "ACCOUNT", action = "ACCOUNT_CREATED")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
<<<<<<< HEAD:src/main/java/com/example/siya/controller/AccountController.java

=======
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AccountController.java
        if (accountRepo.existsByAccountNumber(account.getAccountNumber())) {
            return ResponseEntity.badRequest()
                    .body("Account already exists");
        }

        accountRepo.save(account);
        return ResponseEntity.ok("Account created successfully");
    }
<<<<<<< HEAD:src/main/java/com/example/siya/controller/AccountController.java
=======
    @Auditable(module = "account", action = "account_check")
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<String> getBalance(@PathVariable String accountNumber) {

        Account account = accountRepo.findByAccountNumber(accountNumber)
                .orElse(null);

        if (account == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Account number not found!");
        }

        return ResponseEntity.ok("₹ " + account.getBalance());
    }
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AccountController.java
}
