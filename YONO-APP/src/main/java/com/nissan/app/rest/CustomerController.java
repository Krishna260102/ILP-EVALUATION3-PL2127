package com.nissan.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.app.dto.CustomerDTO;
import com.nissan.app.model.Customer;
import com.nissan.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/*@GetMapping("/active")
    public List<CustomerDTO> getActiveCustomers() {
        List<CustomerDTO> activeCustomers = customerService.getActiveCustomers(); // Implement this method
        return activeCustomers;
    }*/
	
	/*@GetMapping("/active")
    public ResponseEntity<List<CustomerDTO>> getActiveCustomers() {
        List<CustomerDTO> activeCustomers = customerService.getActiveCustomers();

        if (activeCustomers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(activeCustomers, HttpStatus.OK);
    }*/

	@PostMapping("/deposit")
	public ResponseEntity<Customer> deposit(@RequestParam String accountNumber, @RequestParam double amount) {
		// Validate account number and amount (e.g., check for null or invalid values)
		if (accountNumber == null || amount <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		// Implement logic to deposit money
		Customer updatedCustomer = customerService.deposit(accountNumber, amount);

		if (updatedCustomer != null) {
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/withdraw")
	public ResponseEntity<Customer> withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
		// Validate account number and amount
		if (accountNumber == null || amount <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		// Implement logic to withdraw money
		Customer updatedCustomer = customerService.withdraw(accountNumber, amount);

		if (updatedCustomer != null) {
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestParam String fromAccount, @RequestParam String toAccount,
			@RequestParam double amount) {
		// Validate account numbers and amount
		if (fromAccount == null || toAccount == null || amount <= 0) {
			return new ResponseEntity<>("Invalid request parameters", HttpStatus.BAD_REQUEST);
		}

		//Implement logic to transfer money
		Customer success = customerService.transfer(fromAccount, toAccount, amount);

		if (success != null) {
			return new ResponseEntity<>("Transfer successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Transfer failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/balance")
	public ResponseEntity<Double> getBalance(@RequestParam String accountNumber) {
		// Validate account number
		if (accountNumber == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		// Implement logic to get balance
		double balance = customerService.getBalance(accountNumber);

		return new ResponseEntity<>(balance, HttpStatus.OK);
	}
}