package com.coda.springboot.Bean;

import java.util.ArrayList;
import java.util.List;

import com.coda.springboot.Entity.ProductEntity;

public class ProductMapperImpl implements ProductMapper{

	@Override
	public ProductEntity productToEntity(Product product) {
		// TODO Auto-generated method stub
		return new ProductEntity(product.getName(), product.getCategory(), product.getDescription());
	}

	@Override
	public Product entityToProduct(ProductEntity entity) {
		// TODO Auto-generated method stub
		return new Product(entity.getId(), entity.getName(), entity.getCategory(), entity.getDescription());
	}

	@Override
	public List<Product> productListToEntityList(List<ProductEntity> pe) {
		List<Product> productList = new ArrayList<Product>();
		pe.forEach(p->productList.add(this.entityToProduct(p)));
		return productList;
	}

}
