package com.nissan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String customerName;
    private String accountType;
    private double balance;
    private double minBalance;
    private String mobileNumber;
    private String email;
    private String atmPin;
    private String panNO;

    public Account(Long id, String accountNumber, String customerName, String accountType, double balance,
			double minBalance, String mobileNumber, String email, String atmPin, String panNO) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.atmPin = atmPin;
		this.panNO = panNO;
	}

	// Constructors (Generated automatically by IDE or manually if needed)
    public Account() {
    }


    public String getPanNO() {
		return panNO;
	}

	public void setPanNO(String panNO) {
		this.panNO = panNO;
	}

	// Getters and Setters
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

    public String getAtmPin() {
        return atmPin;
    }

    public void setAtmPin(String atmPin) {
        this.atmPin = atmPin;
    }
}