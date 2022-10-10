package com.estockmarket.authservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterUserDTO extends UserDTO {
    private String password;
}