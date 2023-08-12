package com.RestAPICrudOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPICrudOperation.model.Product;
import com.RestAPICrudOperation.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody  Product p){
		
		return new ResponseEntity<>(productService.save(p),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getbyid/{id}", produces="application/json")
	public ResponseEntity<Product> getbyid(@PathVariable int id){
		
		return new ResponseEntity<Product>(productService.getbyid(id),HttpStatus.OK);
		
	}

	@GetMapping(value="/getbyname/{name}" ,produces="application/json")
	public ResponseEntity<Product> getbyname(@PathVariable String name){
		
		return new ResponseEntity<Product>(productService.getbyname(name),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getall" ,produces="application/json")
	public ResponseEntity<List<Product>> getall(){
		
		
		return new ResponseEntity<List<Product>>(productService.getall(),HttpStatus.OK);
	}
	
}
