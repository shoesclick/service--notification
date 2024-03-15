package com.shoesclick.service.notification.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.service.notification.config.properties.KafkaProperties;
import com.shoesclick.service.notification.exception.BusinessException;
import com.shoesclick.service.notification.mapper.NotificationMapper;
import com.shoesclick.service.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import com.shoesclick.notification.avro.NotificationAvro;
@Service
public class NotificationConsumer {

    private final KafkaProperties kafkaProperties;

    private final NotificationMapper notificationMapper;

    private final NotificationService notificationService;

    public NotificationConsumer(KafkaProperties kafkaProperties, NotificationMapper notificationMapper, NotificationService notificationService) {
        this.kafkaProperties = kafkaProperties;
        this.notificationMapper = notificationMapper;
        this.notificationService = notificationService;
    }


    @KafkaListener(topics = "kfk-order-notification", groupId = "grp-order-notification")
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "true",
            include = BusinessException.class
    )
    public void process(NotificationAvro notificationAvro) throws JsonProcessingException {
        notificationService.process(notificationMapper.map(notificationAvro));
    }

}
