package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.EmployeePosition;
import com.apartment.repo.EmployeePositionRepo;
import com.apartment.request.EmployeePositionRequest;
import com.apartment.service.EmployeePositionService;

@Service
public class EmployeePositionServiceImpl implements EmployeePositionService {

	@Autowired
	private EmployeePositionRepo employeePositionRepo;

	@Override
	public void save(EmployeePositionRequest empPositionRequest) {
		EmployeePosition empPosition = new EmployeePosition();
		empPosition.setPositionName(empPositionRequest.getPositionName());
		empPosition.setSalary(empPositionRequest.getSalary());
		empPosition.setResponsibilities(empPositionRequest.getResponsibilities());
		
		employeePositionRepo.save(empPosition);
	}

	@Override
	public List<EmployeePosition> fetchAll() {
		return employeePositionRepo.findAll();
	}
}
