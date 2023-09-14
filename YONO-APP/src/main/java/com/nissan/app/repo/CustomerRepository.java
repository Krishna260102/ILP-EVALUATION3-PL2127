package com.nissan.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nissan.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByAccountNumber(String accountNumber);

    // Other custom queries if needed
    @Modifying
    @Query("UPDATE com.nissan.app.model.Customer SET isAlive=0 WHERE id=?1")
	public void deleteAccount(long id);
    // Example of a custom query:
    // List<Customer> findByAccountType(String accountType);

}