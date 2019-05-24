package com.coda.springboot.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	@Getter @Setter
	private int id;
	
	@Getter @Setter 
	@NotNull
	@Size(max = 20)
	private String name;
	
	@Getter @Setter 
	@NotNull
	private String category;
	
	@Getter @Setter 
	private String description; 
	
	public Product() {} 
	
	public Product(int id, String name, String category, String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
	}
}
