package com.fpoly.asm.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class TokenResponse implements Serializable {
    private String accessToken;
    private String refreshToken;
    private AccountResponse account;
}
