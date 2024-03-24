package com.shoesclick.service.notification.config;

import com.shoesclick.service.notification.config.properties.CacheProperties;
import com.shoesclick.service.notification.config.properties.KafkaProperties;
import com.shoesclick.service.notification.config.properties.TokenProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({KafkaProperties.class, CacheProperties.class, TokenProperties.class})
public class ServiceNotificationConfig {
}
