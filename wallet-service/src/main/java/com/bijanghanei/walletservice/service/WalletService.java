package com.bijanghanei.walletservice.service;

import com.bijanghanei.walletservice.dto.InputDto;
import com.bijanghanei.walletservice.dto.WalletDto;
import com.bijanghanei.walletservice.entity.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface WalletService {
    Wallet findWalletById(Integer id);
    Double getBalance(Integer id);
    WalletDto getWalletBalance(Integer id);
    void commit(Wallet wallet);
    void createWallet();
    HttpStatus updateWalletBalance(InputDto dto);
}
