package com.RestAPICrudOperation.service;

import java.util.List;

import com.RestAPICrudOperation.model.Product;

public interface ProductService {
	
	
	public String save(Product p);
	
	public Product getbyid(int id);
	
	public Product getbyname(String name);
	
	public List<Product> getall();

}
