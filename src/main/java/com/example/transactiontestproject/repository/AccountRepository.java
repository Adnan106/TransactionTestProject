package com.example.transactiontestproject.repository;

import com.example.transactiontestproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
