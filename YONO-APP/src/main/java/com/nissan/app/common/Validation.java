package com.nissan.app.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	//name validation
	public Boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");
			Matcher nameMatcher = namePattern.matcher(name);
			if(nameMatcher.find()) {
				throw new InvalidNameException("Hey! Invalid Name");
				
			}else {
				bool = true;
			}
			
		}catch(InvalidNameException e) {
			e.getMessage();
		}
		return bool;
		
		
	}
	
	 // Account number validation
    public Boolean isAccountNumberValid(String accountNumber) {
        try {
            Pattern accountPattern = Pattern.compile("[^0-9]");
            Matcher accountMatcher = accountPattern.matcher(accountNumber);
            if(accountMatcher.find() || accountNumber.length() != 10) {
                throw new InvalidNameException("Hey! Invalid Account Number");
            } else {
                return true;
            }
        } catch(InvalidNameException e) {
            e.getMessage();
            return false;
        }
    }

    // Phone number validation
    public Boolean isPhoneNumberValid(String phoneNumber) {
        try {
            Pattern phonePattern = Pattern.compile("[^0-9]");
            Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
            if(phoneMatcher.find() || phoneNumber.length() != 10) {
                throw new InvalidNameException("Hey! Invalid Phone Number");
            } else {
                return true;
            }
        } catch(InvalidNameException e) {
            e.getMessage();
            return false;
        }
    }
}