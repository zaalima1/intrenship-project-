<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java
package com.example.siya.entity;
=======
package VaultCore_Financial.entity;


>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java
=======
	 
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java

	    private String txnId;
	    private String fromAccount;
	    private String toAccount;
	    private Double amount;

<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java
	    private LocalDateTime createdAt;   // 👈 MUST EXIST
=======
	    private LocalDateTime timestamp;   // 👈 MUST EXIST
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java

	    private String status;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java
=======
		

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java
		public String getTxnId() {
			return txnId;
		}

		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}

		public String getFromAccount() {
			return fromAccount;
		}

		public void setFromAccount(String fromAccount) {
			this.fromAccount = fromAccount;
		}

		public String getToAccount() {
			return toAccount;
		}

		public void setToAccount(String toAccount) {
			this.toAccount = toAccount;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
=======
		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

<<<<<<< HEAD:src/main/java/com/example/siya/entity/Transaction.java

=======
		
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Transaction.java

}
