<<<<<<< HEAD:src/main/java/com/example/siya/repo/AccountRepository.java
package com.example.siya.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.siya.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

=======
package VaultCore_Financial.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import VaultCore_Financial.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String email);

    boolean existsByAccountNumber(String accountNumber);
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/repo/AccountRepository.java
}
