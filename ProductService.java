package com.hefshine.ecom.service;

import java.util.*;

//import com.hefshine.ecom.controller;
import com.hefshine.ecom.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	void deleteProduct(Long id);

	Product updateProduct(Long id, Product product);

	List<Product> searchProducts(String searchTerm);

	List<Product> findByCategory(String category);

	Product getProductById(Long id);

}
