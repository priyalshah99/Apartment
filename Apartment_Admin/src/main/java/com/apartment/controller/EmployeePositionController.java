package com.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.models.EmployeePosition;
import com.apartment.request.EmployeePositionRequest;
import com.apartment.service.EmployeePositionService;

@RestController
@RequestMapping("/employeePositions")
public class EmployeePositionController {

	@Autowired
	private EmployeePositionService employeePositionService;
	
	@PostMapping("/")
	public String saveEmployeePosition(@RequestBody final EmployeePositionRequest empPositionRequest) {
		employeePositionService.save(empPositionRequest);
		return "Employee Position saved successfully";
	}
	
	@GetMapping("/")
	public List<EmployeePosition> fetchAll() {
		return employeePositionService.fetchAll();
	}
}
