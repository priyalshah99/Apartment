package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
}
