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

import com.apartment.request.EmployeeDetailsRequest;
import com.apartment.response.EmployeeResponse;
import com.apartment.service.EmployeeDetailsService;

@RestController
@RequestMapping("/employeeDetails")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService employeeService;
	
	@PostMapping("/")
	public String addEmployee(@RequestBody EmployeeDetailsRequest empRequest) {
		employeeService.saveEmployee(empRequest);
		return "Employee added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable final long id,@RequestBody EmployeeDetailsRequest empRequest) {
		employeeService.saveEmployee(id, empRequest);
		return "Employee updated successfully";
	}
	
	@PutMapping("/{id}/active")
	public EmployeeResponse activeEmployee(@PathVariable final long id) {
		return EmployeeResponse.build(employeeService.setActive(id, true));
		
	}
	
	@PutMapping("/{id}/inactive")
	public EmployeeResponse inactiveEmployee(@PathVariable final long id) {
		return EmployeeResponse.build(employeeService.setActive(id, false));

	}
	
	@GetMapping("/")
	public List<EmployeeResponse> fetchAll() {
		return employeeService.fetchAll()
				.stream()
				.map(emp -> EmployeeResponse.build(emp))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public EmployeeResponse fetch(@PathVariable final long id) {
		return EmployeeResponse.build(employeeService.fetch(id));
	}
}
