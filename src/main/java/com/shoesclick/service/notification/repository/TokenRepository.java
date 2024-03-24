package com.shoesclick.service.notification.repository;

import com.shoesclick.service.notification.entity.SsoToken;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "tokenClient", url = "${token.tokenUrl}")
public interface TokenRepository {


    @RequestLine("POST /protocol/openid-connect/token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    SsoToken getToken(@Param("grant_type") String grantType, @Param("client_id") String clientId, @Param("client_secret") String clientSecret);


}
