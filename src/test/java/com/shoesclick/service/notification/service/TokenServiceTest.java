package com.shoesclick.service.notification.service;

import com.shoesclick.service.notification.config.properties.TokenProperties;
import com.shoesclick.service.notification.entity.SsoToken;
import com.shoesclick.service.notification.repository.TokenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TokenServiceTest {

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private TokenProperties tokenProperties;

    @InjectMocks
    private TokenService tokenService;


    @BeforeEach
    void setup(){
        when(tokenProperties.clientId()).thenReturn("CLIENT-ID");
        when(tokenProperties.clientSecret()).thenReturn("CLIENT-SECRET");
        when(tokenProperties.grantType()).thenReturn("GRANT-TYPE");
    }

    @Test
    void shouldGetTokenSuccess(){
        when(tokenRepository.getToken(anyString(),anyString(),anyString())).thenReturn(new SsoToken());
        var token = tokenService.getToken();
        assertNotNull(token);
    }

    @Test
    void shouldGetTokenIsNull(){
        when(tokenRepository.getToken(anyString(),anyString(),anyString())).thenReturn(null);
        var token = tokenService.getToken();
        assertNull(token);
    }
}
