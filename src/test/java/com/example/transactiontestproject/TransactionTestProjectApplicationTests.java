/*package com.example.transactiontestproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.transactiontestproject.entity.Account;
import com.example.transactiontestproject.exception.AccountNotFoundException;
import com.example.transactiontestproject.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.transactiontestproject.service.AccountService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private AccountService accountService;

    private Account sender;
    private Account receiver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sender = new Account();
        sender.setId(1L);
        sender.setAccountType("Savings");
        sender.setBalance(1000.0);

        receiver = new Account();
        receiver.setId(2L);
        receiver.setAccountType("Checking");
        receiver.setBalance(500.0);
    }

    @Test
    void testTransfer_Success() {
        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(java.util.Optional.of(receiver));

        String result = accountService.transfer(1L, 2L, 200.0);

        assertEquals("Transfer successful! Sender balance: 800.0, Receiver balance: 700.0", result);
        assertEquals(800.0, sender.getBalance());
        assertEquals(700.0, receiver.getBalance());
        verify(accountRepository, times(2)).save(any(Account.class));
    }

    @Test
    void testTransfer_AccountNotFound() {
        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(java.util.Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> {
            accountService.transfer(1L, 2L, 200.0);
        });
    }

    @Test
    void testTransfer_InsufficientBalance() {
        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(java.util.Optional.of(receiver));

        assertThrows(RuntimeException.class, () -> {
            accountService.transfer(1L, 2L, 1500.0);
        });
    }
}*/
