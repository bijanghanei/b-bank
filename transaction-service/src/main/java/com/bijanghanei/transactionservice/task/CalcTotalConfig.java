package com.bijanghanei.transactionservice.task;

import com.bijanghanei.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalcTotalConfig {

    @Autowired
    private TransactionService transactionService;

    @Bean
    public Runnable newRunnable(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };
    }
}
