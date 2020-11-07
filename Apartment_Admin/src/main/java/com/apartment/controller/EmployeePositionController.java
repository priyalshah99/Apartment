package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.EmployeePositionRequest;
import com.apartment.response.EmployeePositionResponse;
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
	public List<EmployeePositionResponse> fetchAll() {
		return employeePositionService.fetchAll()
				.stream()
				.map(pos -> EmployeePositionResponse.build(pos))
				.collect(Collectors.toList());
	}
	
	@PutMapping("/{id}")
	public String updateEmployeePosition(@PathVariable final long id,@RequestBody final EmployeePositionRequest empPositionRequest) {
		employeePositionService.save(id, empPositionRequest);
		return "Employee Position updated successfully";
	}

	@GetMapping("/{id}")
	public EmployeePositionResponse getOne(@PathVariable final long id) {
		return EmployeePositionResponse.build(employeePositionService.fetch(id));
	}
	
}
