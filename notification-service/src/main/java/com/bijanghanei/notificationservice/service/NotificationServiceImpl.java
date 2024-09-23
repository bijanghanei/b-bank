package com.bijanghanei.notificationservice.service;

import com.bijanghanei.notificationservice.dto.WalletUpdateMessageDto;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Override
    public void sendEmail(WalletUpdateMessageDto dto) {
        String emailMessage = this.createEmailMessage(dto);
        System.out.println("################################################\n" + emailMessage+"################################################\n" );
    }
    private String createEmailMessage(WalletUpdateMessageDto dto) {
        double amount = dto.getType() == 0 ? dto.getAmount() : (-1)*dto.getAmount();
        return MessageFormat.format("Client ID {0} ," +
                        " Balance: {1}, Transaction Amount: {2}," +
                        " Transaction Date and Time: {3}", dto.getUserId()
                        ,dto.getBalance(), amount, dto.getDateTime());
    }
}
