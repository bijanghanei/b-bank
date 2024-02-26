package com.bijanghanei.walletservice.service;

import com.bijanghanei.walletservice.dto.WalletDto;
import com.bijanghanei.walletservice.entity.Wallet;
import com.bijanghanei.walletservice.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet findWalletById(Integer id) {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public Double getBalance(Integer id) {
        Double b = walletRepository.findById(id).orElseThrow().getBalance();
        return b;
    }

    @Override
    public WalletDto getWalletBalance(Integer id) {
        Wallet w = walletRepository.findById(id).orElse(null);
        if (w != null){
            return new WalletDto(w.getBalance());
        }else {
            System.out.println("wallet not found");
            return null;
        }
    }

    @Override
    public void commit(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public void createWallet() {
        Wallet w = new Wallet();
        w.setBalance(0);
        walletRepository.save(w);
    }

    @Override
    public HttpStatus updateWalletBalance(Integer id, double amount) {
        Wallet wallet = walletRepository.findById(id).orElse(null);
        if (wallet != null){
            wallet.setBalance(wallet.getBalance()+amount);
            walletRepository.save(wallet);
            return HttpStatus.OK;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }
}
