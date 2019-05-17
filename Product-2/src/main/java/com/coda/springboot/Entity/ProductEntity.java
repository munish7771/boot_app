package com.coda.springboot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
//import lombok.extern.log4j.Log4j;
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private int id;

	@Getter @Setter 
	@NotNull
	@Size(max = 20)
	private String name;
	
	@Getter @Setter 
	@NotNull
	@Size(max = 15 ,min = 5)
	private String category;
	
	@Getter @Setter 
	@Size(max = 100, min = 10)
	private String description; 
	
	protected ProductEntity() {} 
	
	public ProductEntity(String name, String category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
}
