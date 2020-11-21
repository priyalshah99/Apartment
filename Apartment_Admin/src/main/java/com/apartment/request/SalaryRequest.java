package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryRequest {

	private String datePaid;
	private double amountPaid;
	private int noOfLeaves;	
    private Long employeeId;
    
	/*
	 * { 
	 * "datePaid":"01/11/2020",
	 *  "amountPaid":20000,
	 *   "noOfLeaves":2,
	 *    "employeeId":1
	 * }
	 */
}
