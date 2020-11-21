package com.apartment.service;

import java.util.List;

import com.apartment.models.Salary;
import com.apartment.request.SalaryRequest;

public interface SalaryService {

	void saveSalary(final SalaryRequest salaryRequest);
	
	void updateSalary(final Long id, final SalaryRequest salaryRequest);
	
	List<Salary> getAll();
	
	Salary getSalary(final Long id);
	
	void deleteSalary(final Long id);
}
