package com.shoesclick.service.notification.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.service.notification.config.properties.KafkaProperties;
import com.shoesclick.service.notification.mapper.NotificationMapper;
import com.shoesclick.service.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.shoesclick.notification.avro.NotificationAvro;
import org.springframework.kafka.support.KafkaHeaders;

import java.util.Map;

@Component
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
    public void process(@Payload NotificationAvro notificationAvro, @Header(name = KafkaHeaders.RECEIVED_KEY) String key) throws JsonProcessingException {
        System.out.println("KEY:"+ key);
        System.out.println("Headers:");
       // headers.forEach((item, value) -> System.out.println(item + ": " + String.valueOf(value)));
        notificationService.process(notificationMapper.map(notificationAvro));
    }

}
