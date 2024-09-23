package com.bijanghanei.notificationservice.service;

import com.bijanghanei.notificationservice.dto.WalletUpdateMessageDto;

public interface NotificationService {
    void sendEmail(WalletUpdateMessageDto dto);
}
