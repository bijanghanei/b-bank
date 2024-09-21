package com.bijanghanei.transactionservice.rabbitmq;

import com.bijanghanei.transactionservice.dto.WalletUpdateMessageDto;
import com.bijanghanei.transactionservice.entity.Transaction;
import com.bijanghanei.transactionservice.external.Wallet;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class WalletUpdateMessageProducer {
    final RabbitTemplate rabbitTemplate;

    public WalletUpdateMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(Transaction transaction, Wallet wallet) {
        WalletUpdateMessageDto dto = WalletUpdateMessageDto.builder().userId(transaction.getUserId()).amount(transaction.getAmount())
                .balance(wallet.getBalance()).type(transaction.getType()).dateTime(transaction.getDate()).build();
        rabbitTemplate.convertAndSend("updateBalanceQueue",dto);
    }
}
