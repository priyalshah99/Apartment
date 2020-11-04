package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Expense;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseResponse {
	private Long expenseId;
	private double amount;
	private String date;
	private String reason;
	
	public static ExpenseResponse build(final Expense expense) {
		ExpenseResponse expenseResponse = new ExpenseResponse();
		expenseResponse.setExpenseId(expense.getExpenseId());
		expenseResponse.setAmount(expense.getAmount());
		expenseResponse.setReason(expense.getReason());
		expenseResponse.setDate(expense.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return expenseResponse;
	}
}
