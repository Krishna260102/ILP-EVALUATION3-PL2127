package com.nissan.app.dto;

public class TransactionDTO {
    private String accountNumber;
    private double amount;

    // Constructors
    public TransactionDTO() {
    }

    public TransactionDTO(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    // Getters and Setters
    
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}






