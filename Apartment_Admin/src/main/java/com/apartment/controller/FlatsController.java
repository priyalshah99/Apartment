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
	
	@PutMapping("/{id}")
	public String updateFlats(@PathVariable final int id,@RequestBody FlatsRequest request) {
		flatsService.updateFlat(id, request);
		return "Flats  updated successfully";
	}
	
	@PutMapping("/{id}/occupied")
	public FlatResponse activeEmployee(@PathVariable final int id) {
		return FlatResponse.build(flatsService.setOccupied(id, true));
		
	}
	
	@PutMapping("/{id}/vacant")
	public FlatResponse inactiveEmployee(@PathVariable final int id) {
		return FlatResponse.build(flatsService.setOccupied(id, false));

	}
	
	
	@GetMapping("/occupied")
	public List<FlatResponse> fetchOccupied() {
		return flatsService.getOccupiedFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/vacant")
	public List<FlatResponse> fetchEmpty() {
		return flatsService.getEmptyFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/")
	public List<FlatResponse> fetchAll() {
		return flatsService.getAllFlats().stream().map(flt->FlatResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/fetch/{id}")
	public FlatResponse fetch(@PathVariable final int id) {
		return FlatResponse.build(flatsService.getFlats(id));
	}
	
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final int id) {
		flatsService.deleteFlats(id);
		return "Flats entry deleted successfully";
	}
	
	@GetMapping("/fetchbyowner/{id}")
	public List<FlatResponse> fetchByOwner(@PathVariable final Long id) {
	
		return flatsService.getAllByOwner(id)
				.stream()
				.map(inc -> FlatResponse.build(inc))
				.collect(Collectors.toList());
	
	}
}
