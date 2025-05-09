package com.fpoly.asm.controller.response;

import com.fpoly.asm.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private Role role;

    public AccountResponse(int i, String testUser) {
    }
}

