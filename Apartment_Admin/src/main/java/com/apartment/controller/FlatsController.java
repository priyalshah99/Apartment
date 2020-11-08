package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.FlatsRequest;
import com.apartment.response.FlatResponse;
import com.apartment.service.FlatsService;

@RestController
@RequestMapping("/flats")
@CrossOrigin(origins="http://localhost:4200")
public class FlatsController {

	@Autowired
	private FlatsService flatsService;
	
	@PostMapping("/")
	public String addFlat(@RequestBody final FlatsRequest flatRequest) {
		flatsService.saveFlat(flatRequest);
		return "Flat added successfully";
	}
	
	@GetMapping("/occupied")
	public List<FlatResponse> fetchOccupied() {
		return flatsService.getOccupiedFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/empty")
	public List<FlatResponse> fetchEmpty() {
		return flatsService.getEmptyFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/")
	public List<FlatResponse> fetchAll() {
		return flatsService.getAllFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	
}
