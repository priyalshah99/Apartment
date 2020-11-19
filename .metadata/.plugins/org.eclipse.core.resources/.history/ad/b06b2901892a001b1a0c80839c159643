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

import com.apartment.request.FundsRequest;
import com.apartment.request.MaintenanceRequest;
import com.apartment.response.FundsResponse;
import com.apartment.response.MaintenanceResponse;
import com.apartment.service.FundsService;
import com.apartment.service.MaintenanceService;

@RestController
@RequestMapping("/funds")
@CrossOrigin(origins="http://localhost:4200")
public class FundsController {

	@Autowired
	private FundsService fundsService;
	
	
	@PostMapping("/")
	public String add(@RequestBody FundsRequest request) {
		fundsService.saveFunds(request);
		return "Funds entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable final Long id, @RequestBody final FundsRequest request) {
		fundsService.updateFunds(id, request);
		return "Funds entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final Long id) {
		fundsService.deleteFunds(id);
		return "Funds entry deleted successfully";
	}
	
	@GetMapping("/fetch/{id}")
	public FundsResponse fetch(@PathVariable final Long id) {
		return FundsResponse.build(fundsService.getFunds(id));
	}
	
	@GetMapping("/")
	public List<FundsResponse> fetchAll() {
		return fundsService.getAll()
				.stream()
				.map(inc -> FundsResponse.build(inc))
				.collect(Collectors.toList());
	}

	
	
}
