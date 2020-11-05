package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceRequest {
	private double amount;
	private String date;
	private String month;
	private String paymentMode;
    private String flatNo;
}

/*
{
	"amount":2000,
	"date":"25/10/2020",
	"month":"August",
	"paymentMode":"Cheque",
	"flatNo":"A-102"
}
 */
