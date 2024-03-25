package com.shoesclick.service.notification.service;

import com.shoesclick.service.notification.config.properties.TokenProperties;
import com.shoesclick.service.notification.entity.SsoToken;
import com.shoesclick.service.notification.mapper.TokenMapper;
import com.shoesclick.service.notification.repository.TokenRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    private final TokenProperties tokenProperties;

    private final TokenMapper tokenMapper;

    private static final String CACHE_TOKEN = "cache_token_notification";

    public TokenService(TokenRepository tokenRepository, TokenProperties tokenProperties, TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenProperties = tokenProperties;
        this.tokenMapper = tokenMapper;
    }

    @Cacheable(value=CACHE_TOKEN, key = "#root.methodName")
    public SsoToken getToken(){
        return tokenRepository.getToken(tokenMapper.map(tokenProperties));
    }
}
