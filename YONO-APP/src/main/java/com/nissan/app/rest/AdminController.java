package com.nissan.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.app.dto.CustomerDTO;
import com.nissan.app.model.Customer;
import com.nissan.app.service.AccountService;
import com.nissan.app.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//		System.out.println("ram");
//		Validate customer data (e.g., check for required fields, etc.)
//		if (customer.getName() == null || customer.getAccountType() == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
        System.out.println(customer);
		// Implement logic to add a new customer
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

//		if (newCustomer != null) {
//			return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// Implement other admin actions (update, delete, list)

	@PutMapping("/updateCustomer/{accountId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long accountId, @RequestBody Customer customer) {
		// Implement logic to update a customer
		Customer updatedCustomer = customerService.updateCustomer(accountId, customer);

		if (updatedCustomer != null) {
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/deleteCustomer/{accountId}")
    public /*ResponseEntity<String>*/void deleteCustomer(@PathVariable Long accountId) {
//        boolean deleted = customerService.deleteCustomer(accountId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
//        }
		customerService.deleteCustomer(accountId);
    }

	@GetMapping("/listCustomers")
	public ResponseEntity<List<Customer>> listCustomers() {
		// Implement logic to list all customers
		List<Customer> customers = customerService.getAllCustomers();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	
	@GetMapping("/listCustomersAlive")
	public List<CustomerDTO> listCustomersIsAlive() {
		return accountService.listCustomersIsAlive();
		// Implement logic to list all customers
		
	}
	
	
	
	
}