package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {
	private double amount;
	private String date;
	private String reason;
}

/*
{
	"amount":1000,
	"date":"13/10/2020",
	"reason":""
} 
 */
