package com.example.banking_app.repository;

import com.example.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositioryInterface extends JpaRepository<Account, Long> {

}
