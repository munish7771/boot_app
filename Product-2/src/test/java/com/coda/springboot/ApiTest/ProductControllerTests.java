package com.coda.springboot.ApiTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coda.springboot.Bean.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {
	
	@Autowired
	private MockMvc mvc;
	// TO-Do mockito
	@Test	
    public void getAllProductsTest() throws Exception{
		
		  mvc.perform( MockMvcRequestBuilders
			      .get("/products/")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
    }
	// need something for mock database. or to check only the web API.
	@Test
	public void insertProduct() throws Exception{
		Product product = new Product();
		product.setName("test_product");
		product.setCategory("test_category");
		product.setDescription("test_description");
		mvc.perform( MockMvcRequestBuilders
				.post("/products/")
				.content(asJsonString(product))
			    .contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("OK"));
	}
	
	@Test
	public void insertProductInvalid() throws Exception{
		Product product = new Product();
		product.setName("test_product");
		product.setCategory("test_category");
		product.setDescription("test_des");
		mvc.perform( MockMvcRequestBuilders
				.post("/products/")
				.content(asJsonString(product))
			    .contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(content().string("Some Error!"));
	}
	
	@Test
	public void deleteProduct() throws Exception{
		int _id = 19;
		mvc.perform( MockMvcRequestBuilders
				.delete("/products/{id}",_id))
				.andExpect(status().isAccepted());
		// just added 19th Product
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
