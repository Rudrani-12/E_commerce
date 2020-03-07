package com.example.ecommerce.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl {
	
@Autowired
private ProductRepository repository;

public List<Product> getAllProducts(){
	List<Product> productList = repository.findAll();
	if(productList.size() > 0) {
		return productList;
	}
	else
		return new ArrayList<Product>();
}
public Product getProductByID(long id) throws Exception {
	Optional<Product> product = repository.findById(id);
	if(product.isPresent()) {
		return product.get();
	}
	else {
		throw new Exception("Record not Found");
	}
}

public Product createOrUpdateProduct(Product product) {
	Optional<Product> product_obj = repository.findById(product.getId());
	if(product_obj.isPresent()){
		Product newProduct = product_obj.get();
		newProduct.setPrice(product.getPrice());
		newProduct.setProductName(product.getProductName());
		
		newProduct= repository.save(newProduct);
		return newProduct;
	}
	else {
		product = repository.save(product);
		return product;
	}
}

public void deleteProduct(long id) throws Exception {
	Optional<Product> product = repository.findById(id);
	if(product.isPresent()) {
		repository.deleteById(id);
	}
	else {
		throw new Exception("Product is not Present");
	}
}
}
