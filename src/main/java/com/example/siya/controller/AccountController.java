package com.example.siya.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.siya.entity.Account;
import com.example.siya.entity.Auditable;
import com.example.siya.repo.AccountRepository;

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

        if (accountRepo.existsByAccountNumber(account.getAccountNumber())) {
            return ResponseEntity.badRequest()
                    .body("Account already exists");
        }

        accountRepo.save(account);
        return ResponseEntity.ok("Account created successfully");
    }
}
