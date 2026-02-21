<<<<<<< HEAD:src/main/java/com/example/siya/entity/Account.java
package com.example.siya.entity;
=======
package VaultCore_Financial.entity;

import java.math.BigDecimal;

import org.apache.poi.hpsf.Decimal;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Account.java

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

   
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String accountNumber;
<<<<<<< HEAD:src/main/java/com/example/siya/entity/Account.java
        private Double balance;

        private String username;
=======
        
        @Column(nullable = false)
        private Double balance = 500000.0;


        private String username;
        
        @OneToOne(mappedBy = "account")
        private Admin admin;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Account.java

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Double getBalance() {
			return balance;
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
<<<<<<< HEAD:src/main/java/com/example/siya/entity/Account.java
        
=======

		public Admin getAdmin() {
			return admin;
		}

		public void setAdmin(Admin admin) {
			this.admin = admin;
		}

		
		
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Account.java



	

  
}
