package com.bijanghanei.notificationservice.rabbitmq;

import com.bijanghanei.notificationservice.dto.WalletUpdateMessageDto;
import com.bijanghanei.notificationservice.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletUpdateMessageConsumer {
    private final NotificationService service;

    public WalletUpdateMessageConsumer(RabbitTemplate rabbitTemplate, NotificationService service) {
        this.service = service;
    }
    @RabbitListener(queues = "updateBalanceQueue")
    public void consume(WalletUpdateMessageDto message) {
        service.sendEmail(message);
    }
}
