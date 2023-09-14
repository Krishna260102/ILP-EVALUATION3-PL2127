package com.nissan.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nissan.app.dto.CustomerDTO;
import com.nissan.app.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom queries for account management
	

    // Example of a custom query to find accounts by account type
    List<Account> findByAccountType(String accountType);
    

    
    @Query("SELECT NEW com.nissan.app.dto.CustomerDTO(c.customerName,c.accountType,c.mobileNumber,c.email) FROM com.nissan.app.model.Customer c WHERE c.isAlive = 1")
    public List<CustomerDTO> listCustomersIsAlive();
    
    
    
    
}