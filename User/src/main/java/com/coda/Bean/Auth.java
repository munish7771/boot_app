package com.coda.Bean;

import lombok.Data;

@Data
public class Auth {
	private String username;
	private String password;
	private int role;
}
