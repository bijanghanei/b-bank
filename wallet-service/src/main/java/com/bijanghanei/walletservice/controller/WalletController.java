package com.bijanghanei.walletservice.controller;

import com.bijanghanei.walletservice.dto.InputDto;
import com.bijanghanei.walletservice.dto.WalletDto;
import com.bijanghanei.walletservice.entity.Wallet;
import com.bijanghanei.walletservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("balance/{id}")
    public ResponseEntity<WalletDto> GetBalance(@PathVariable Integer id){
        return new ResponseEntity<>(walletService.getWalletBalance(id),HttpStatus.OK);
    }
    @GetMapping("wallet/{id}")
    public ResponseEntity<Wallet> GetWallet(@PathVariable Integer id){
        return new ResponseEntity<>(walletService.findWalletById(id),HttpStatus.OK);
    }

    @PutMapping
    public HttpStatus UpdateBalance(@RequestBody InputDto input){
        return walletService.updateWalletBalance(input.getUserId(),input.getAmount());
    }
    @PostMapping
    public void CreateWallet(){
        walletService.createWallet();
    }
}
