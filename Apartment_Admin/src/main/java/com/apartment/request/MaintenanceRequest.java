package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceRequest {
	private double amount;
	private String date;
	private int month;
	private String paymentMode;
    private String flatNo;
}

/*
{
	"amount":2000,
	"date":"25/10/2020",
	"month":10,
	"paymentMode":"Cheque",
	"flatNo":"A-102"
}
 */
