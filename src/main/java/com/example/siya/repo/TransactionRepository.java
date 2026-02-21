package com.example.siya.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.siya.entity.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{
	@Query("SELECT t FROM Transaction t " +
		       "WHERE (t.fromAccount = :accountNumber OR t.toAccount = :accountNumber)")
		List<Transaction> findAllTransactions(
		        @Param("accountNumber") String accountNumber
		);



}
