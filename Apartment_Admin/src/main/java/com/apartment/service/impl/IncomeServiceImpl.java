package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.IncomeRepo;
import com.apartment.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeRepo incomeRepo;
	
}
