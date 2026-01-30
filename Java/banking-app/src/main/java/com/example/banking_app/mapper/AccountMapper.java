package com.example.banking_app.mapper;

import com.example.banking_app.dto.AccountDTO;
import com.example.banking_app.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDTO accountDTO){
//        Account account = new Account(
//                accountDTO.getId(),
//                accountDTO.getAccountHolderName(),
//                accountDTO.getBalance()
//        );
        //using java records as dto
        Account account = new Account(
                accountDTO.id(),
                accountDTO.accountHolderName(),
                accountDTO.balance()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}
