package com.coda.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="credential")
public class AuthEntity {
	@Id
	@Size(max = 20, min = 5)
	private String username;
	
	@NotNull
	@Pattern(regexp = "(?=^.{8,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!@#$%^&*()]*$")
	private String password;
	
	@NotNull
	@Pattern(regexp = "[01]")
	// 0 for user
	// 1 for admin
	private int role;
}
