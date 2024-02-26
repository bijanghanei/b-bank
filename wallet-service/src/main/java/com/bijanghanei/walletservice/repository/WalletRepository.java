package com.bijanghanei.walletservice.repository;

import com.bijanghanei.walletservice.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
