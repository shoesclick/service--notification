package com.shoesclick.service.notification.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.service.notification.config.NotificationMetrics;
import com.shoesclick.service.notification.config.properties.KafkaProperties;
import com.shoesclick.service.notification.mapper.NotificationMapper;
import com.shoesclick.service.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.shoesclick.notification.avro.NotificationAvro;
import org.springframework.kafka.support.KafkaHeaders;

@Component
public class NotificationConsumer {

    private final KafkaProperties kafkaProperties;

    private final NotificationMapper notificationMapper;

    private final NotificationService notificationService;

    private final NotificationMetrics notificationMetrics;

    public NotificationConsumer(KafkaProperties kafkaProperties, NotificationMapper notificationMapper, NotificationService notificationService, NotificationMetrics notificationMetrics) {
        this.kafkaProperties = kafkaProperties;
        this.notificationMapper = notificationMapper;
        this.notificationService = notificationService;
        this.notificationMetrics = notificationMetrics;
    }


    @KafkaListener(topics = "kfk-order-notification", groupId = "grp-order-notification")
    public void process(@Payload NotificationAvro notificationAvro, @Header(name = KafkaHeaders.RECEIVED_KEY) String key) throws JsonProcessingException {
        System.out.println("KEY:"+ key);
        notificationService.process(notificationMapper.map(notificationAvro));
        notificationMetrics.incrementNotificationSuccessCount();
    }

}
