package com.bijanghanei.transactionservice.service;

import com.bijanghanei.transactionservice.client.WalletClient;
import com.bijanghanei.transactionservice.dto.InputDto;
import com.bijanghanei.transactionservice.dto.TransactionDto;
import com.bijanghanei.transactionservice.entity.Transaction;
import com.bijanghanei.transactionservice.external.Wallet;
import com.bijanghanei.transactionservice.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
//    @Autowired
//    RestTemplate restTemplate;
    private final TransactionRepository transactionRepository;
    private final WalletClient walletClient;

    public TransactionServiceImpl(TransactionRepository transactionRepository, WalletClient walletClient) {
        this.transactionRepository = transactionRepository;
        this.walletClient = walletClient;
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
//        Wallet wallet = restTemplate.getForObject("http://wallet-service:8082/wallet/"+input.getUserId()
//                ,Wallet.class);

        Wallet wallet = walletClient.getWallet(input.getUserId());
        if (wallet!=null){
//            RestTemplate updateRestTemplate = new RestTemplate();
//            HttpEntity<InputDto> request = new HttpEntity<>(input);
//            ResponseEntity<HttpStatus> response = restTemplate.exchange("http://wallet-service:8082", HttpMethod.PUT,request,HttpStatus.class);

            ResponseEntity<HttpStatus> response = walletClient.updateWallet(input);
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
