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

import com.apartment.models.Election;
import com.apartment.request.ElectionRequest;
import com.apartment.response.ElectionResponse;
import com.apartment.service.ElectionService;

@RestController
@RequestMapping("/election")
@CrossOrigin(origins="http://localhost:4200")
public class ElectionController {

	@Autowired
	private ElectionService electionService; 
	
	@PostMapping("/")
	public String add(@RequestBody ElectionRequest request) {
		electionService.saveElection(request);
		return "Election entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable final Long id, @RequestBody final ElectionRequest request) {
		electionService.updateElection(id, request);
		return "Election entry updated successfully";
	}
	
	@PutMapping("/{id}/active")
	public ElectionResponse activeElection(@PathVariable final long id) {
		return ElectionResponse.build(electionService.setActive(id, true));
		
	}
	
	@PutMapping("/{id}/inactive")
	public ElectionResponse inactiveElection(@PathVariable final long id) {
		return ElectionResponse.build(electionService.setActive(id, false));

	}	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final Long id) {
		electionService.deleteElection(id);
		return "Election entry deleted successfully";
	}
	
	@GetMapping("/{state}")
	public List<Election> getElection(@PathVariable final String state) {
		return electionService.fetchElection(state);
	}
	
	@GetMapping("/fetch/{id}")
	public ElectionResponse fetch(@PathVariable final Long id) {
		return ElectionResponse.build(electionService.getElection(id));
	}
	
	@GetMapping("/")
	public List<ElectionResponse> fetchAll() {
		return electionService.getAll()
				.stream()
				.map(inc -> ElectionResponse.build(inc))
				.collect(Collectors.toList());
	}
}
