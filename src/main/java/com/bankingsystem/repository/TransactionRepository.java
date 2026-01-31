package com.bankingsystem.repository;

import com.bankingsystem.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import com.bankingsystem.model.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TransactionRepository
        extends MongoRepository<Transaction, String> {

    List<Transaction> findByAccountId(String accountId);

    Page<Transaction> findByAccountIdAndTransactionType(
            String accountId,
            TransactionType transactionType,
            Pageable pageable
    );
}

