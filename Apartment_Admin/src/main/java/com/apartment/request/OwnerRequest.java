package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerRequest {

	private String name;
	private String contactNo;
	private String email;
	private String dateOfPurchase;
	
/*
 {
 	"name":"Priyal Shah",
 	"contactNo":"9878787878",
 	"email":"pshah@gmail.com",
 	"dateOfPurchase":"27/12/2019"
 }
 */
}
