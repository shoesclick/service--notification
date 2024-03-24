package com.shoesclick.service.notification.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SsoToken {

    private String accesToken;

    private String expiresIn;

    private String tokenType;

    public String getAccesToken() {
        return accesToken;
    }

    public SsoToken setAccesToken(String accesToken) {
        this.accesToken = accesToken;
        return this;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public SsoToken setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public SsoToken setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
