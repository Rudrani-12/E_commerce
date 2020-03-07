package com.example.ecommerce.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="ProductName" ,nullable=false)
	private String ProductName;
	
	@Column(name="Product Price")
	private Double price;

	public Product(long id, @NotNull(message = "Product Name is Required") String productName, Double price) {
		this.id = id;
		ProductName = productName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
