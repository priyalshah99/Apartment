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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.exception.RecordAlreadyExistException;
import com.apartment.request.IncomeRequest;
import com.apartment.response.IncomeResponse;
import com.apartment.service.IncomeService;

@RestController
@RequestMapping("/income")
@CrossOrigin(origins="http://localhost:4200")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
	
	@PostMapping("/")
	public String addIncome(@RequestBody IncomeRequest incomeRequest) throws RecordAlreadyExistException {
		incomeService.saveIncome(incomeRequest);
		return "Income entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateIncome(@PathVariable Long id, @RequestBody IncomeRequest incomeRequest) {
		incomeService.saveIncome(id, incomeRequest);
		return "Income entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteIncome(@PathVariable Long id) {
		incomeService.deleteIncome(id);
		return "Income entry deleted successfully";
	}
	
	@GetMapping("/{id}")
	public IncomeResponse fetchIncome(@PathVariable Long id) {
		return IncomeResponse.build(incomeService.fetch(id));
	}
	
	@GetMapping("/")
	public List<IncomeResponse> fetchAll() {
		return incomeService.fetchAll()
				.stream()
				.map(inc -> IncomeResponse.build(inc))
				.collect(Collectors.toList());
		
	}
	
	@GetMapping("/filter")
	public List<IncomeResponse> filter(@RequestParam final String startDate, @RequestParam final String endDate) {
		return incomeService.filter(startDate, endDate)
				.stream()
				.map(inc -> IncomeResponse.build(inc))
				.collect(Collectors.toList());
		/*
		 * Double sum = data.stream().mapToDouble(d -> d.getAmount()).sum();
		 * TotalResponse response = new TotalResponse(); response.setCount(data.size());
		 * // response.setData(data); response.setSum(sum); return response;
		 */
		
		
		}
}
