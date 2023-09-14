package com.nissan.app.dto;

public class CustomerDTO {
    private String customerName;
    private String accountType;
    private String mobileNumber;
    private String email;
  

    // Constructors
    public CustomerDTO() {
    }


	public CustomerDTO(String customerName, String accountType, String mobileNumber, String email) {
		super();
		this.customerName = customerName;
		this.accountType = accountType;
		this.mobileNumber = mobileNumber;
		this.email = email;
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

}
    
    // Getters and Setters
    
	