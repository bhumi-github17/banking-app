package com.example.banking_app.service.implementation;

import com.example.banking_app.dto.AccountDTO;
import com.example.banking_app.entity.Account;
import com.example.banking_app.mapper.AccountMapper;
import com.example.banking_app.repository.AccountRepositioryInterface;
import com.example.banking_app.service.AccountServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplementation implements AccountServiceInterface {
    private AccountRepositioryInterface accountRepositioryInterface;

    public AccountServiceImplementation(AccountRepositioryInterface accountRepositioryInterface) {
        this.accountRepositioryInterface = accountRepositioryInterface;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepositioryInterface.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepositioryInterface
                .findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account Does Not Exists"));
        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long accountId, double amount) {
        Account account = accountRepositioryInterface
                .findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account Does Not Exists with id:"+accountId));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedBalance = accountRepositioryInterface.save(account);
        return AccountMapper.mapToAccountDTO(savedBalance);
    }

    @Override
    public AccountDTO withdraw(Long accountId, double withdrawAmount) {
        Account account = accountRepositioryInterface
                .findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account Does Not Exists with id:"+accountId));
        if (account.getBalance() < withdrawAmount){
            throw new RuntimeException("Insufficient Balance");
        }
        double total = account.getBalance() - withdrawAmount;
        account.setBalance(total);
        Account updatedBalance = accountRepositioryInterface.save(account);
        return AccountMapper.mapToAccountDTO(updatedBalance);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepositioryInterface.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
                .collect(Collectors.toList());

    }

    @Override
    public AccountDTO updateAccount(Long accountId, AccountDTO accountDTO) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepositioryInterface.findById(accountId).orElseThrow(()-> new RuntimeException("Account Does not exists"));
        accountRepositioryInterface.deleteById(accountId);
    }


}
