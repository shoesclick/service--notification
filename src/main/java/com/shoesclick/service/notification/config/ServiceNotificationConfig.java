package com.shoesclick.service.notification.config;

import com.shoesclick.service.notification.config.properties.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class ServiceNotificationConfig {
}
