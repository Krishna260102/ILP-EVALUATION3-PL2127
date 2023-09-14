package com.nissan.app.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;  // Will be generated automatically
    private String customerName;
    private String accountType;
    private double balance;
    private double minBalance;
    private String mobileNumber;
    private String email;
    private String atmPin;
    private boolean isAlive=true;
    private String panNO;

    // Constructors, if needed
    public Customer() {
        // Default constructor
    }

    public Customer(String customerName, String accountType, double balance, double minBalance,
                    String mobileNumber, String email, String atmPin, boolean isAlive , String panNO) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.minBalance = minBalance;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.atmPin = atmPin;
        this.isAlive = isAlive;
        this.panNO = panNO;
    }

    // Getters and Setters
   
    public String getPanNO() {
		return panNO;
	}

	public void setPanNO(String panNO) {
		this.panNO = panNO;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	// Custom method to generate account number
    @PrePersist
    private void generateAccountNumber() {
        this.accountNumber = generateRandomAccountNumber();
    }

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

	private String generateRandomAccountNumber() {
        // Implement logic to generate a random account number (e.g., using UUID or a custom method)
        // Example: return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        return String.format("%06d", new Random().nextInt(1000000));
    }

    
    
  
	@Override
	public String toString() {
		return "Customer [id=" + id + ", accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", accountType=" + accountType + ", balance=" + balance + ", minBalance=" + minBalance
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", atmPin=" + atmPin + ", isAlive=" + isAlive
				+ ", panNO=" + panNO + "]";
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
