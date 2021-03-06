package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.SalaryRequest;
import com.apartment.response.SalaryResponse;
import com.apartment.service.SalaryService;

@RestController
@RequestMapping("/salary")
@CrossOrigin(origins="http://localhost:4200")
public class SalaryController {

	@Autowired
	private SalaryService salaryService;
	
	
	@PostMapping("/")
	public String add(@RequestBody SalaryRequest request) {
		salaryService.saveSalary(request);
		return "salary entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable final Long id, @RequestBody final SalaryRequest request) {
		salaryService.updateSalary(id, request);
		return "salary entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final Long id) {
		salaryService.deleteSalary(id);
		return "salary entry deleted successfully";
	}
	
	@GetMapping("/fetch/{id}")
	public SalaryResponse fetch(@PathVariable final Long id) {
		return SalaryResponse.build(salaryService.getSalary(id));
	}
	
	@GetMapping("/")
	public List<SalaryResponse> fetchAll() {
		return salaryService.getAll()
				.stream()
				.map(inc -> SalaryResponse.build(inc))
				.collect(Collectors.toList());
	}

}
