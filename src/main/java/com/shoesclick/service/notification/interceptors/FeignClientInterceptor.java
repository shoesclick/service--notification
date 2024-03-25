package com.shoesclick.service.notification.interceptors;

import com.shoesclick.service.notification.entity.SsoToken;
import com.shoesclick.service.notification.service.TokenService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";
    
    private final TokenService tokenService;

    public FeignClientInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, getTokenJwt().getAccessToken()));
    }

    private SsoToken getTokenJwt() {
        return tokenService.getToken();
    }


}
