package com.estockmarket.authservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
	@Id
	private int id;

	@Indexed(unique = true, name = "_email")
	private String email;

	@Indexed(unique = true, name = "_username")
	private String username;

	private String password;

	private long phoneNo;
	
	private String fullName;

	private boolean confirmed;

    private String confirmationCode;
}
