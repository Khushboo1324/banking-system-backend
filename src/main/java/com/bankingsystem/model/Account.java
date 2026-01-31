package com.bankingsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String accountNumber;
    private Double balance;
    private AccountType accountType;
    private String userId;
}
