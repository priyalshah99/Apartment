package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Income;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeResponse {
	private Long incomeId;
	private double amount;
	private String date;
	private String name; 
	private String contactNo;
	private String reason;
	
	public static IncomeResponse build(final Income income) {
		IncomeResponse incomeResponse = new IncomeResponse();
		incomeResponse.setIncomeId(income.getIncomeId());
		incomeResponse.setAmount(income.getAmount());
		incomeResponse.setDate(income.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		incomeResponse.setName(income.getName());
		incomeResponse.setContactNo(income.getContactNo());
		incomeResponse.setReason(income.getReason());
		return incomeResponse;
	}
}
