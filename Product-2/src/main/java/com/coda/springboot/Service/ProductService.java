package com.coda.springboot.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coda.springboot.Bean.Product;
@Service
public interface ProductService {
	public String insertProduct(Product product);
	public List<Product> getAllProducts();
	public boolean deleteProduct(int id); 
	public boolean editProduct(Product product);
}
