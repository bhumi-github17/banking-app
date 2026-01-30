package com.example.banking_app.service;

import com.example.banking_app.dto.AccountDTO;
import com.example.banking_app.entity.Account;

import java.util.List;

public interface AccountServiceInterface {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long accountId);
    AccountDTO deposit(Long accountId, double amount);
    AccountDTO withdraw(Long accountId, double withdrawAmount);
    List<AccountDTO> getAllAccounts();
    AccountDTO updateAccount(Long accountId, AccountDTO accountDTO);
    void deleteAccount(Long accountId);
}
