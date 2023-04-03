package com.usermanager.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString(exclude = {"password"})
public class CredentialsDTO implements Serializable{

	@Serial
	private static final long serialVersionUID = 3787034525399435017L;
	private String email;

	private String password;

}
