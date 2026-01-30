package com.example.banking_app.controller;

import com.example.banking_app.dto.AccountDTO;
import com.example.banking_app.service.implementation.AccountServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountServiceImplementation accountServiceImplementation;

    public AccountController(AccountServiceImplementation accountServiceImplementation) {
        this.accountServiceImplementation = accountServiceImplementation;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountServiceImplementation.createAccount(accountDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("id") Long accountId){
        AccountDTO accountDTO = accountServiceImplementation.getAccountById(accountId);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable("id") Long accountId,@RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountServiceImplementation.deposit(accountId, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable("id") Long accountId,@RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountServiceImplementation.withdraw(accountId, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccountById(){
        List<AccountDTO> accountDTO = accountServiceImplementation.getAllAccounts();
        return ResponseEntity.ok(accountDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long accountId){
        accountServiceImplementation.deleteAccount(accountId);
        return ResponseEntity.ok("Account id:" + String.valueOf(accountId)+ " Deleted Successfully");
    }


}
