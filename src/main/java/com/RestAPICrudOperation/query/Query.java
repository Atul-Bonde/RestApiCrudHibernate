package com.RestAPICrudOperation.query;

import org.springframework.stereotype.Component;

@Component
public class Query {

	public static String finbyname="from Product where name=:X";
	
	public static String updateprice="update Product set price=:X where name=:Y";
	
	
}
