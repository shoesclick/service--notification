package com.shoesclick.service.notification.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbitmq")
public record MqProperties(String exchange, MQNotificationProperties notification) {}

