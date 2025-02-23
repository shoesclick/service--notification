package com.shoesclick.service.notification.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
public record TokenProperties(String clientId, String clientSecret, String grantType) {
}
