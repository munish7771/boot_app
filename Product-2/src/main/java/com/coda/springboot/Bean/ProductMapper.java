package com.coda.springboot.Bean;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.coda.springboot.Entity.ProductEntity;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	// for future attribute names
	ProductEntity productToEntity(Product product);
	
	Product entityToProduct(ProductEntity entity);
	
	List<Product> productListToEntityList(List<ProductEntity> pe);
}
