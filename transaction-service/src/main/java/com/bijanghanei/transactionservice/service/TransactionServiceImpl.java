package com.bijanghanei.transactionservice.service;

import com.bijanghanei.transactionservice.dto.InputDto;
import com.bijanghanei.transactionservice.dto.TransactionDto;
import com.bijanghanei.transactionservice.entity.Transaction;
import com.bijanghanei.transactionservice.external.Wallet;
import com.bijanghanei.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    RestTemplate restTemplate;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findTransactionById(String id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    @Override
    public TransactionDto addMoney(InputDto input) {
//        RestTemplate restTemplate = new RestTemplate();
        Wallet wallet = restTemplate.getForObject("http://wallet-service:8082/wallet/"+input.getUserId()
                ,Wallet.class);
        if (wallet!=null){
//            RestTemplate updateRestTemplate = new RestTemplate();
            HttpEntity<InputDto> request = new HttpEntity<>(input);
            ResponseEntity<HttpStatus> response = restTemplate.exchange("http://wallet-service:8082", HttpMethod.PUT,request,HttpStatus.class);

            if (response.getBody() == HttpStatus.OK){
                Transaction transaction = new Transaction();
                transaction.setUserId(input.getUserId());
                transaction.setAmount(input.getAmount());
                transactionRepository.save(transaction);

                return new TransactionDto(transaction.getId());
            }
        }
        return null;
    }

    @Override
    public void commit(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    @Scheduled(cron= " 0 0 15 * * *")
    public void calcTotal() {
        List<Transaction> transactions = transactionRepository.findAll();
        double total = 0;
        for (Transaction t : transactions){
            total = Double.sum(total,t.getAmount());
        }
        System.out.println(total);
    }
}
