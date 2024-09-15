package com.hefshine.ecom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hefshine.ecom.entity.Product;
import com.hefshine.ecom.repository.ProductRepository;
import com.hefshine.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setColor(product.getColor());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setImage(product.getImage());
		return productRepository.save(existingProduct);
	}

	@Override
	public List<Product> searchProducts(String searchTerm) {
		return productRepository.searchProducts(searchTerm);
	}

	@Override
	public List<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product getProductById(Long id) {
		// Use findById to fetch the product by ID
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

}
