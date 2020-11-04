package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.EmployeeDetails;
import com.apartment.repo.EmployeeDetailsRepo;
import com.apartment.repo.EmployeePositionRepo;
import com.apartment.request.EmployeeDetailsRequest;
import com.apartment.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepo;
	
	@Autowired
	private EmployeePositionRepo empPositionRepo;

	@Override
	public void saveEmployee(EmployeeDetailsRequest empRequest) {
		EmployeeDetails employee = new EmployeeDetails();
		employee.setName(empRequest.getName());
		employee.setContact(empRequest.getContact());
		employee.setAddress(empRequest.getAddress());
		employee.setActive(empRequest.isActive());
		employee.setEmployeePosition(empPositionRepo.getOne(empRequest.getEmployeePositionId()));
		
		employeeDetailsRepo.save(employee);
		
	}

	@Override
	public void saveEmployee(Long id, EmployeeDetailsRequest empRequest) {
		EmployeeDetails employee = employeeDetailsRepo.getOne(id);
		employee.setName(empRequest.getName());
		employee.setContact(empRequest.getContact());
		employee.setAddress(empRequest.getAddress());
		employee.setActive(empRequest.isActive());
		employee.setEmployeePosition(empPositionRepo.getOne(empRequest.getEmployeePositionId()));
		
		employeeDetailsRepo.save(employee);
	}

	@Override
	public EmployeeDetails setActive(Long id, boolean active) {
		EmployeeDetails employee = employeeDetailsRepo.getOne(id);
		employee.setActive(active);
		employeeDetailsRepo.save(employee);
		return employee;
	}

	@Override
	public EmployeeDetails fetch(Long id) {
		return employeeDetailsRepo.getOne(id);
	}

	@Override
	public List<EmployeeDetails> fetchAll() {
		return employeeDetailsRepo.findAll();
	}
}
