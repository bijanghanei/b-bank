package com.bijanghanei.transactionservice.task;

import com.bijanghanei.transactionservice.entity.Transaction;
import com.bijanghanei.transactionservice.service.TransactionService;
import com.bijanghanei.transactionservice.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class CalculateTotal implements Runnable {


//    @Autowired
//    private TransactionService transactionService;




//    private List<Transaction> transactions = new ArrayList<>();
//    private int length = 0;
//    private int lastIndex = 0;
//    private double total = 0;
    @Override
    public void run() {
//        transactions = transactionService.findAll();
//        int newLen = transactions.size();
//        if (newLen>length){
//            length = newLen;
//            for (int i =  lastIndex; i<length; i++){
//                total = Double.sum(total,transactions.get(i).getAmount());
//            }
//            lastIndex = length;
//            System.out.println(total);
//        }else{
//            System.out.println(total);
//        }

//        for (Transaction t : transactions){
//            total++;
//        }
//        System.out.println(total);
//        transactionService.calcTotal();
        System.out.println("task");
    }
}
