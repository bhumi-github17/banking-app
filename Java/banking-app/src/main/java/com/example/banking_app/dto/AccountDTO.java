package com.example.banking_app.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//public class AccountDTO {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//}

// using JAVA Record Class as DTO. cannot modify(immutable)
public  record AccountDTO(Long id, String accountHolderName, double balance) {
}