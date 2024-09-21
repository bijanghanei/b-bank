package com.bijanghanei.walletservice.dto;

import lombok.Getter;

@Getter
public class InputDto {
    private Integer userId;
    private double amount;
    private Byte type;
}
