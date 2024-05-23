package com.example.authenticationservice.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TokenDTO {
    private String access_token;
    private String refresh_token;

    public TokenDTO(String access_token, String refresh_token) {
    }
}
