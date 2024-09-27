package com.bijanghanei.notificationservice.service;

import com.bijanghanei.notificationservice.dto.WalletUpdateMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(WalletUpdateMessageDto dto) {
        SimpleMailMessage emailMessage = this.createEmailMessage(dto);
        sender.send(emailMessage);
    }
    private SimpleMailMessage createEmailMessage(WalletUpdateMessageDto dto) {
        double amount = dto.getType() == 0 ? dto.getAmount() : (-1)*dto.getAmount();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("<receiver email address>");
        mailMessage.setSubject("Transaction Occurred");
        mailMessage.setText(
                MessageFormat.format("Wallet ID: {0} ," +
                        " Balance: {1}, Transaction Amount: {2}," +
                        " Transaction Date and Time: {3}", dto.getUserId()
                ,dto.getBalance(), amount, dto.getDateTime())
        );
        return mailMessage;
    }
}
