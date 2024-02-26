package com.bijanghanei.transactionservice.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer userId;
    @Nonnull
    private double amount;
    private Date date;

    public Transaction(String id, Integer userId, @Nonnull double amount , Date date) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.date = new Date();
    }
}
