package com.bijanghanei.transactionservice.dto;

import com.bijanghanei.transactionservice.entity.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputDto {
    private Integer userId;
    private double amount;
    private Byte type;
}
