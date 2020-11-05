package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeRequest {
	private double amount;
	private String date;
	private String name; 
	private String contactNo;
	private String reason;
}

/*
{
	"amount":1000,
	"date":"13/10/2020",
	"name":"P Shah",
	"contactNo":"9978486115",
	"reason":"Advance payment for hall booking"
}
 */
