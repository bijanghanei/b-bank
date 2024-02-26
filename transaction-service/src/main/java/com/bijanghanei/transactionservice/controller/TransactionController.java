package com.bijanghanei.transactionservice.controller;

import com.bijanghanei.transactionservice.dto.InputDto;
import com.bijanghanei.transactionservice.dto.TransactionDto;
import com.bijanghanei.transactionservice.entity.Transaction;
import com.bijanghanei.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> GetTransactions(){
        return transactionService.findAll();
    }
    @PostMapping
    public TransactionDto AddMoney(@RequestBody InputDto input){
        return transactionService.addMoney(input);
    }
}
