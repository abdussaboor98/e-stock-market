package com.estockmarket.authservice.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String username;

	private String email;

	private String fullName;
	
	private long phoneNo;
}
