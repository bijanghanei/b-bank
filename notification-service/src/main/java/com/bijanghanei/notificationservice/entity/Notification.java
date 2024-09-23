package com.bijanghanei.notificationservice.entity;

import jakarta.annotation.Nonnull;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    @Nonnull
    private String userId;
    @Nonnull
    private String message;
}
