package com.RestAPICrudOperation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPICrudOperation.model.Product;
import com.RestAPICrudOperation.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String save(Product p) {

		logger.info("Save Product Starting Point ");
		
		Integer save = productRepository.save(p);

		if (save == null) {
			
			logger.info("Save Product Ending Point ");

			return "Product is Not Saved";
			
			
		} else {

			return "Product Saved Successfully";
		}
		

	}

	@Override
	public Product getbyid(int id) {

		logger.info("Get Product By Id Starting Point");
		
		Product findyid = productRepository.findyid(id);
		
		logger.info("Get Product By Id Ending Point ");

		return findyid;

	}

	@Override
	public Product getbyname(String name) {
		
		logger.info("Get Product By Name Starting Point");

		Product findbyname = productRepository.findbyname(name);

		logger.info("Get Product By Name Ending Point ");
		
		return findbyname;
	}

	@Override
	public List<Product> getall() {
		
		logger.info("Get All Product Starting Point ");

		List<Product> getall = productRepository.getall();
		
		logger.info("Get All Product Ending Point ");

		return getall;
	}

}
