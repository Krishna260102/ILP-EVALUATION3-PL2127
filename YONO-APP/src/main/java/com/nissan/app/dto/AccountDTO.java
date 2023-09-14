package com.nissan.app.dto;

public class AccountDTO {
    private String accountNumber;
    private String customerName;
    private String accountType;
    private double balance;
    private double minBalance;
    private String mobileNumber;
    private String email;
    private boolean isActive; // Added field

    // Constructors
    public AccountDTO() {
    }

    public AccountDTO(String accountNumber, String customerName, String accountType, double balance, double minBalance,
                      String mobileNumber, String email, boolean isActive) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.minBalance = minBalance;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.isActive = isActive;
    }

    
    // Getters and Setters

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

    
}
