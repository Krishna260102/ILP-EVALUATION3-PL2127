package com.nissan.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.app.dto.CustomerDTO;
import com.nissan.app.exceptions.InsufficientFundsException;
import com.nissan.app.model.Customer;
import com.nissan.app.repo.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
    	System.out.println("hi ram");
        customer.setAtmPin(generateRandomAtmPin());
        return customerRepository.save(customer);
    }

    public Customer deposit(String accountNumber, double amount) {
        Optional<Customer> optionalCustomer = customerRepository.findByAccountNumber(accountNumber);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            double newBalance = customer.getBalance() + amount;
            customer.setBalance(newBalance);

            return customerRepository.save(customer);
        } else {
            throw new EntityNotFoundException("Customer not found for account number: " + accountNumber);
        }
    }

    public Customer withdraw(String accountNumber, double amount) {
        Optional<Customer> optionalCustomer = customerRepository.findByAccountNumber(accountNumber);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Check if there are sufficient funds
            if (customer.getBalance() - amount >= customer.getMinBalance()) {
                double newBalance = customer.getBalance() - amount;
                customer.setBalance(newBalance);

                return customerRepository.save(customer);
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        } else {
            throw new EntityNotFoundException("Customer not found for account number: " + accountNumber);
        }
    }

    public Customer transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Optional<Customer> optionalFromCustomer = customerRepository.findByAccountNumber(fromAccountNumber);
        Optional<Customer> optionalToCustomer = customerRepository.findByAccountNumber(toAccountNumber);

        if (optionalFromCustomer.isPresent() && optionalToCustomer.isPresent()) {
            Customer fromCustomer = optionalFromCustomer.get();
            Customer toCustomer = optionalToCustomer.get();

            // Check if there are sufficient funds for transfer
            if (fromCustomer.getBalance() - amount >= fromCustomer.getMinBalance()) {
                double newFromBalance = fromCustomer.getBalance() - amount;
                fromCustomer.setBalance(newFromBalance);

                double newToBalance = toCustomer.getBalance() + amount;
                toCustomer.setBalance(newToBalance);

                customerRepository.save(fromCustomer);
                customerRepository.save(toCustomer);

                return fromCustomer;
            } else {
                throw new InsufficientFundsException("Insufficient funds for transfer.");
            }
        } else {
            throw new EntityNotFoundException("One or both customers not found for account numbers: " + fromAccountNumber + " and " + toAccountNumber);
        }
    }

    public double getBalance(String accountNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findByAccountNumber(accountNumber);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get().getBalance();
        } else {
            throw new EntityNotFoundException("Customer not found for account number: " + accountNumber);
        }
    }

    private String generateRandomAtmPin() {
        Random random = new Random();
        int pin = random.nextInt(10000);
        return String.format("%04d", pin);
    }

    public Customer updateCustomer(Long accountId, Customer customer) {
        // Find the existing customer by account ID
        Optional<Customer> existingCustomerOptional = customerRepository.findById(accountId);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            
            // Update customer information with the provided data
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setAccountType(customer.getAccountType());
            existingCustomer.setBalance(customer.getBalance());
            existingCustomer.setMinBalance(customer.getMinBalance());
            existingCustomer.setMobileNumber(customer.getMobileNumber());
            existingCustomer.setEmail(customer.getEmail());
            
            // Save and return the updated customer
            return customerRepository.save(existingCustomer);
        } else {
            // If the customer with the given ID does not exist, return null (or handle the error as needed)
            return null;
        }
    }

    @Transactional
    public void deleteCustomer(Long accountId) {
//        Optional<Customer> optionalCustomer = customerRepository.findById(accountId);
//
//        if (optionalCustomer.isPresent()) {
//            customerRepository.delete(optionalCustomer.get());
//            return true; // Return true if customer is successfully deleted
//        }
//
//        return false; // Return false if customer with given accountId is not found
    	customerRepository.deleteAccount(accountId);
    }


	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	/*public List<CustomerDTO> getActiveCustomers() {
        List<Customer> activeCustomers = customerRepository.findByIsActiveTrue();
        List<CustomerDTO> activeCustomersDTO = new ArrayList<>();

        for (Customer customer : activeCustomers) {
            CustomerDTO dto = convertToDTO(customer);
            activeCustomersDTO.add(dto);
        }

        return activeCustomersDTO;
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setAccountType(customer.getAccountType());
        dto.setActive(customer.isActive());
        return dto;
    }*/

}

