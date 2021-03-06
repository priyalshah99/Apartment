package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.ExpenseRequest;
import com.apartment.response.ExpenseResponse;
import com.apartment.service.ExpenseService;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins="http://localhost:4200")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/")
	public String addExpense(@RequestBody final ExpenseRequest expenseRequest) {
		expenseService.saveExpense(expenseRequest);
		return "Expense added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateExpense(@PathVariable final Long id, @RequestBody final ExpenseRequest expenseRequest) {
		expenseService.saveExpense(id, expenseRequest);
		return "Expense updated successfully";
	}
	
	@GetMapping("/{id}")
	public ExpenseResponse fetch(@PathVariable final Long id) {
		return ExpenseResponse.build(expenseService.getExpenseRecord(id));
	}
	
	@GetMapping("/") 
	public List<ExpenseResponse> fetchAll() {
		return expenseService.getAll()
				.stream()
				.map(exp -> ExpenseResponse.build(exp))
				.collect(Collectors.toList());
	}
	
	@DeleteMapping("/{id}")
	public String deleteExpense(@PathVariable final Long id) {
		expenseService.deleteExpense(id);
		return "Expense deleted successfully";
	}
}
