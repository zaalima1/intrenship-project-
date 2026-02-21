<<<<<<< HEAD:src/main/java/com/example/siya/service/TransactionService.java
package com.example.siya.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.siya.entity.Account;
import com.example.siya.entity.Auditable;
import com.example.siya.entity.Transaction;
import com.example.siya.repo.AccountRepository;
import com.example.siya.repo.TransactionRepository;

=======
package VaultCore_Financial.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import VaultCore_Financial.entity.Account;
import VaultCore_Financial.entity.Auditable;
import VaultCore_Financial.entity.Transaction;
import VaultCore_Financial.repo.AccountRepository;
import VaultCore_Financial.repo.TransactionRepository;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/TransactionService.java
import jakarta.transaction.Transactional;

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
<<<<<<< HEAD:src/main/java/com/example/siya/service/TransactionService.java
        txn.setFromAccount(fromAcc);
        txn.setToAccount(toAcc);
        txn.setAmount(amount);
        txn.setCreatedAt(LocalDateTime.now());
=======
        
        txn.setFromAccount(fromAcc);
        txn.setToAccount(toAcc);
        txn.setAmount(amount);
        txn.setTimestamp(LocalDateTime.now());
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/TransactionService.java
        txn.setStatus("SUCCESS");

        txnRepo.save(txn);
    }
<<<<<<< HEAD:src/main/java/com/example/siya/service/TransactionService.java
=======
    public List<Transaction> getTransactionsByAccount(String accountNumber) {
        return txnRepo.findByFromAccountOrToAccount(accountNumber, accountNumber);
    }





>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/TransactionService.java
}
