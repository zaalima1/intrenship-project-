<<<<<<< HEAD:src/main/java/com/example/siya/dto/TransferRequest.java
package com.example.siya.dto;
=======
package VaultCore_Financial.dto;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/dto/TransferRequest.java

public class TransferRequest {
    private String fromAccount;
    private String toAccount;
    private Double amount;
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


}

