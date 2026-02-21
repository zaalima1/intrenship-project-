<<<<<<< HEAD:src/main/java/com/example/siya/repo/TransactionRepository.java
package com.example.siya.repo;
=======
package VaultCore_Financial.repo;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/repo/TransactionRepository.java

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD:src/main/java/com/example/siya/repo/TransactionRepository.java
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
=======
import VaultCore_Financial.entity.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT t FROM Transaction t " +
	           "WHERE (t.fromAccount = :accountNumber OR t.toAccount = :accountNumber) " +
	           "AND t.timestamp BETWEEN :start AND :end")
	    List<Transaction> findMonthlyTransactions(
	            @Param("accountNumber") String accountNumber,
	            @Param("start") LocalDateTime start,
	            @Param("end") LocalDateTime end
	    );
	
	@Query("SELECT t FROM Transaction t " +
		       "WHERE t.fromAccount = :accountNumber OR t.toAccount = :accountNumber " +
		       "ORDER BY t.timestamp DESC")
		List<Transaction> findAllByAccount(@Param("accountNumber") String accountNumber);



	List<Transaction> findByFromAccountOrToAccount(String from, String to);

}

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/repo/TransactionRepository.java
