package com.bijanghanei.notificationservice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class WalletUpdateMessageConsumer {
    final RabbitTemplate rabbitTemplate;

    public WalletUpdateMessageConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @RabbitListener(queues = "updateBalanceQueue")
    public void consume(WalletUpdateMessageConsumer message) {

    }
}
