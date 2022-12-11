package com.speer.interview.dtos;

import java.io.Serial;
import java.io.Serializable;

public class JwtResponseDto implements Serializable {

    private String accessToken;
    private String tokenType = "Bearer";
    @Serial
    private static final long serialVersionUID = -8091879091924046844L;

    public JwtResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getToken() {
        return this.accessToken;
    }

    public void setToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType (String tokenType) {
        this.tokenType = tokenType;
    }
}
