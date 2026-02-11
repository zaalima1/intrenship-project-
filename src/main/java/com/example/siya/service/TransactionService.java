package com.example.siya.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.siya.entity.Account;
import com.example.siya.entity.Auditable;
import com.example.siya.entity.Transaction;
import com.example.siya.repo.AccountRepository;
import com.example.siya.repo.TransactionRepository;

@Service
public class TransactionService {
	
    private final AccountRepository accountRepo;
    private final TransactionRepository txnRepo;

    public TransactionService(AccountRepository accountRepo,
                              TransactionRepository txnRepo) {
        this.accountRepo = accountRepo;
        this.txnRepo = txnRepo;
    }

    @Transactional
    @Auditable(module = "TRANSFER", action = "SEND_MONEY")
    public void sendMoney(String fromAcc, String toAcc, Double amount) {

        Account sender = accountRepo.findByAccountNumber(fromAcc)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account receiver = accountRepo.findByAccountNumber(toAcc)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // debit & credit
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepo.save(sender);
        accountRepo.save(receiver);

        Transaction txn = new Transaction();
        txn.setTxnId("TXN" + System.currentTimeMillis());
        txn.setFromAccount(fromAcc);
        txn.setToAccount(toAcc);
        txn.setAmount(amount);
        txn.setCreatedAt(LocalDateTime.now());
        txn.setStatus("SUCCESS");

        txnRepo.save(txn);
    }
}
