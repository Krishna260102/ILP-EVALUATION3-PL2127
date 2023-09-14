package com.nissan.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.app.dto.CustomerDTO;
import com.nissan.app.model.Account;
import com.nissan.app.repo.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Implement account-related services
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
    	accountRepository.deleteById(id);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    
    public List<CustomerDTO> listCustomersIsAlive() {
		return accountRepository.listCustomersIsAlive();
    	
    }

    // Add more account-related services as needed
}
