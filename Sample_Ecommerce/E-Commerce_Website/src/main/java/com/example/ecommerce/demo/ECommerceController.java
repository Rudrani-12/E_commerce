package com.example.ecommerce.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e-Commerce")
public class ECommerceController {

	@Autowired
	ProductServiceImpl service;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = service.getAllProducts();

		return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id)throws Exception{
		
		Product product = service.getProductByID(id);
		
		return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
	}
	
@PostMapping
public ResponseEntity<Product> createUpdateProduct(Product product){
	Product updatedProduct = service.createOrUpdateProduct(product);
	return new ResponseEntity<Product>(updatedProduct, new HttpHeaders(),HttpStatus.OK);
}
@DeleteMapping("/{id}")
public HttpStatus deletProductById(@PathVariable("id") long id) throws Exception{
	service.deleteProduct(id);
	return HttpStatus.FORBIDDEN;
}

}
