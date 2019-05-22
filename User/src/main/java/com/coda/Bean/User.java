package com.coda.Bean;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.coda.Entity.RoleEntity;
import com.coda.Entity.RoleName;

import lombok.Data;

@Data
public class User {

    private int id;
	

	@NotNull
	@Size(max = 20)
	private String name;
	
	@NotNull
	@Size(max = 20, min = 5)
	private String username;
	
	private String gender;
	
	@Pattern(regexp = "[0-9]{10}$")
	private String phoneNo;
	
	private String password;
	
	private String token;
	
	@NotNull
	private int role;
	
	protected User() {}
	
	public User(int id, String name, String username, String gender, String phoneNumber, String password,Set<RoleEntity> roles) {
		this.password = password;
		this.id =id;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.phoneNo = phoneNumber;
		RoleEntity admin = new RoleEntity();
		admin.setId(2l);
		admin.setName(RoleName.ROLE_ADMIN);
		if(roles.contains(admin)) {
			this.role = 1;
		}else {
			this.role = 0;
		}
	}

}
