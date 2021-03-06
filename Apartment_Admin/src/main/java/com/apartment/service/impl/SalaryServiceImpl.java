package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Salary;
import com.apartment.repo.EmployeeDetailsRepo;
import com.apartment.repo.SalaryRepo;
import com.apartment.request.SalaryRequest;
import com.apartment.service.SalaryService;
import com.apartment.utils.Constants;

@Service
public class SalaryServiceImpl implements SalaryService {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
	
	@Autowired
	private EmployeeDetailsRepo empDetailsRepo;
	
	@Autowired
	private SalaryRepo salaryRepo;

	@Override
	public void saveSalary(SalaryRequest salaryRequest) {

		Salary salary=new Salary();
		
		salary.setDatePaid(LocalDate.parse(salaryRequest.getDatePaid(),formatter));
		salary.setAmountPaid(salaryRequest.getAmountPaid());
		salary.setNoOfLeaves(salaryRequest.getNoOfLeaves());
		salary.setEmployeeDetails(empDetailsRepo.getOne(salaryRequest.getEmployeeId()));
		
		salaryRepo.save(salary);
	}

	@Override
	public void updateSalary(Long id, SalaryRequest salaryRequest) {
		Salary salary=salaryRepo.getOne(id);
		
		salary.setDatePaid(LocalDate.parse(salaryRequest.getDatePaid(),formatter));
		salary.setAmountPaid(salaryRequest.getAmountPaid());
		salary.setNoOfLeaves(salaryRequest.getNoOfLeaves());
		salary.setEmployeeDetails(empDetailsRepo.getOne(salaryRequest.getEmployeeId()));
		
		salaryRepo.save(salary);
		
	}

	@Override
	public List<Salary> getAll() {
		return salaryRepo.findAll();
	}

	@Override
	public Salary getSalary(Long id) {
		return salaryRepo.getOne(id);
	}

	@Override
	public void deleteSalary(Long id) {
		salaryRepo.deleteById(id);
	}
}
