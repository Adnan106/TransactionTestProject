package com.example.transactiontestproject.controller;

import com.example.transactiontestproject.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.transactiontestproject.service.AccountService;


import java.util.List;

@RestController
//@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }
    @GetMapping("/test")
    public String test() {
        return "Application is running!";
    }


    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromAccountId,
                           @RequestParam Long toAccountId,
                           @RequestParam Double amount) {
        // Log the received transfer request
        System.out.println("Transfer request received: " +
                "fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", amount=" + amount);

        // Call the account com.example.transactiontestproject.service to perform the transfer
        return accountService.transfer(fromAccountId, toAccountId, amount);
    }

    // Create a new account
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // Get all accounts
    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Get an account by ID
    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Update an existing account
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        return accountService.updateAccount(id, accountDetails);
    }

    // Delete an account
    @DeleteMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "Account with ID " + id + " deleted successfully!";
    }
}
