package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.SalaryRepo;
import com.apartment.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryRepo salaryRepo;
}
