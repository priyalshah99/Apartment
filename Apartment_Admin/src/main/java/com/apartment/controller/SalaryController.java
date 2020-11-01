package com.apartment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	private SalaryService salaryService;
}
