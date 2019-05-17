package com.coda.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "phoneno"
        })
})

public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 20, min = 2)
	private String name;
	
	@NotNull
	@Column(unique = true)
	@Size(max = 20, min = 5)
	private String username;
	
	@Pattern(regexp = "[MFU]")
	private String gender;
	
	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "[0-9]{10}$")
	private String phoneno;
	
	@NotBlank
	private String password;
	// afterwards --- cant use lazy load
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
	
	protected UserEntity() {} 
	
	public UserEntity(String name, String username, String gender, String phoneno, String password) {
		this.password = password;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.phoneno = phoneno;
	}
	
}
