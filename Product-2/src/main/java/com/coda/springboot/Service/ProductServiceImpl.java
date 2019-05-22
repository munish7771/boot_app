package com.coda.springboot.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coda.springboot.Entity.ProductEntity;

import lombok.extern.log4j.Log4j2;

import com.coda.springboot.Bean.Product;
import com.coda.springboot.Bean.ProductMapperImpl;
import com.coda.springboot.DAL.ProductRepository;

@Service("productService")
@Log4j2
public class ProductServiceImpl  implements ProductService{
	@Autowired 
	private ProductRepository productRepository;
//    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
	ProductMapperImpl mapper = new ProductMapperImpl();
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		List<ProductEntity> pe = null;
		try {
			log.info("In product service");
			pe = (List<ProductEntity>)productRepository.findAll();
			productList = mapper.productListToEntityList(pe);
			return productList;
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return productList;
		}	
	}
	
	@Override
	public String insertProduct(Product product) {
		log.info("In Product service");
		ProductEntity entity = (mapper.productToEntity(product));
		try {
			productRepository.save(entity);
			return "success";
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return "error:ProductService";
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		log.info("In Product service");
		ProductEntity product = null;
		try {
			// throws exception if no product is present.
			product = productRepository.findById(id).get();
			log.info("gotcha product");
			productRepository.delete(product);
			productRepository.flush();
			log.info("deleted");
			return true;
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return false;
		}
	}

	@Override
	public boolean editProduct(Product product) {
		log.info("In Product service");
		try {
			productRepository.save(mapper.productToEntity(product));
			log.info("saved");
			return true;
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return false;
		}
	}
	

}
