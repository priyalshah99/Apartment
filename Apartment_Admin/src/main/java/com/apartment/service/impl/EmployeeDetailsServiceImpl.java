package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.EmployeeDetailsRepo;
import com.apartment.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepo;
}
