package com.coda.springboot.Service;

import java.util.List;

import com.coda.springboot.Bean.Product;

public interface ProductService {
	public String insertProduct(Product product);
	public List<Product> getAllProducts();
	public boolean deleteProduct(int id); 
	public boolean editProduct(Product product);
}
