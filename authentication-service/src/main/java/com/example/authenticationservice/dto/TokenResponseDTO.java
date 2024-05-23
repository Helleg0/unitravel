package com.example.authenticationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record TokenResponseDTO(
        String access_token,
        int expires_in,
        int refresh_expires_in,
        String refresh_token,
        String token_type,
        String session_state,
        String scope) {
}
