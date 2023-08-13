package com.RestAPICrudOperation.exception;

import org.springframework.stereotype.Component;


public class ProductNotFound extends RuntimeException{
	
	    public ProductNotFound(String message){
	    	 
	    	 super(message);
	     }
	

}
