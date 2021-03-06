package com.apartment.service;

import java.util.List;

import com.apartment.models.Expense;
import com.apartment.request.ExpenseRequest;

public interface ExpenseService {
	
	void saveExpense(final ExpenseRequest expenseRequest);
	
	void saveExpense(final Long id, final ExpenseRequest expenseRequest);
	
	List<Expense> getAll();
	
	Expense getExpenseRecord(final Long id);
	
	void deleteExpense(final Long id);

	List<Expense> filter(final String startDate, final String endDate);


}
