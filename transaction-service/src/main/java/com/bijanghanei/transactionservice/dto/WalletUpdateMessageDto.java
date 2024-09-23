package com.bijanghanei.transactionservice.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class WalletUpdateMessageDto {
    private int userId;
    private double balance;
    private double amount;
    private byte type;
    private LocalDateTime dateTime;
}
