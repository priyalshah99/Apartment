package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Expense;
import com.apartment.repo.ExpenseRepo;
import com.apartment.request.ExpenseRequest;
import com.apartment.service.ExpenseService;
import com.apartment.utils.Constants;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

	@Autowired
	private ExpenseRepo expenseRepo;

	@Override
	public void saveExpense(ExpenseRequest expenseRequest) {
		Expense expense = new Expense();
		expense.setAmount(expenseRequest.getAmount());
		expense.setDate(LocalDate.parse(expenseRequest.getDate(),formatter));
		expense.setReason(expenseRequest.getReason());
		expenseRepo.save(expense);
	}

	@Override
	public void saveExpense(Long id, ExpenseRequest expenseRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Expense expense = expenseRepo.getOne(id);
		expense.setAmount(expenseRequest.getAmount());
		expense.setDate(LocalDate.parse(expenseRequest.getDate(),formatter));
		expense.setReason(expenseRequest.getReason());
		expenseRepo.save(expense);		
	}

	@Override
	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseRecord(Long id) {
		return expenseRepo.getOne(id);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

	@Override
	public List<Expense> filter(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Expense> filter(String startDate, String endDate) {
	 * return expenseRepo.findByDateBetween(LocalDate.parse(startDate,formatter),
	 * LocalDate.parse(endDate,formatter)); }
	 */
}
