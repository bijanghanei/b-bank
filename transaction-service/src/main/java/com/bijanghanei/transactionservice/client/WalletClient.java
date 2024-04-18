package com.bijanghanei.transactionservice.client;

import com.bijanghanei.transactionservice.dto.InputDto;
import com.bijanghanei.transactionservice.external.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "wallet-service")
public interface WalletClient {

    @GetMapping("/wallet/{id}")
    Wallet getWallet(@PathVariable("id") Integer id);
    @PutMapping("/wallet/update")
    ResponseEntity<HttpStatus> updateWallet(@RequestBody InputDto inputDto);
}
