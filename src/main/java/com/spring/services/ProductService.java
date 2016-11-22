package com.spring.services;

import java.util.List;

import com.spring.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(int i);
	void addProduct(Product product);
	void editProduct(Product product);
	void deleteProduct(int id);
	

}
