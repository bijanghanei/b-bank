package com.bijanghanei.notificationservice.dto;

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
