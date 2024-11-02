package com.example.transactiontestproject.service;

import com.example.transactiontestproject.entity.Account;
import com.example.transactiontestproject.exception.AccountNotFoundException;
import com.example.transactiontestproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public String transfer(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found."));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Receiver account not found."));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        return "Transfer successful! Sender balance: " + fromAccount.getBalance() +
                ", Receiver balance: " + toAccount.getBalance();
    }

    // Create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get an account by ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + id));
    }

    // Update an existing account
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + id));
        account.setAccountType(accountDetails.getAccountType());
        account.setBalance(accountDetails.getBalance());
        return accountRepository.save(account);
    }

    // Delete an account
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + id));
        accountRepository.delete(account);
    }
}
