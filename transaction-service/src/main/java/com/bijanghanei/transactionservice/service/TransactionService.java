package com.bijanghanei.transactionservice.service;

import com.bijanghanei.transactionservice.dto.InputDto;
import com.bijanghanei.transactionservice.dto.TransactionDto;
import com.bijanghanei.transactionservice.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction findTransactionById(String id);
    TransactionDto addMoney(InputDto input);
    void commit(Transaction transaction);
    void calcTotal();
}
