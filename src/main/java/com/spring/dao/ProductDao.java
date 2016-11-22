package com.spring.dao;

import java.util.List;

import com.spring.model.Product;

public interface ProductDao {
	List <Product>  getAllProducts();
	Product getPrductById(int id);
	 void addProduct(Product product);
	 void editProduct(Product product);
	 void deleteProduct(int id);
}



