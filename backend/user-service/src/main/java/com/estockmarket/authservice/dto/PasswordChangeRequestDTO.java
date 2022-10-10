package com.estockmarket.authservice.dto;

import lombok.Data;

@Data
public class PasswordChangeRequestDTO {
    private String username;
    private String oldPassword;
    private String newPassword;
}
