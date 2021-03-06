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

import com.apartment.request.ElectionPositionRequest;
import com.apartment.response.ElectionPositionResponse;
import com.apartment.service.ElectionPositionService;

@RestController
@RequestMapping("/electionPosition")
@CrossOrigin(origins="http://localhost:4200")
public class ElectionPositionController {
	
	@Autowired
	private ElectionPositionService electionPositionService;
	
	@PostMapping("/")
	public String add(@RequestBody ElectionPositionRequest request) {
		electionPositionService.saveElectionPosition(request);
		return "ElectionPosition entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable final Long id, @RequestBody final ElectionPositionRequest request) {
		electionPositionService.updateElectionPosition(id, request);
		return "ElectionPosition entry updated successfully";
	}
	
	@PutMapping("/{id}/active")
	public ElectionPositionResponse activeElectionPosition(@PathVariable final long id) {
		return ElectionPositionResponse.build(electionPositionService.setActive(id, true));
		
	}
	
	@PutMapping("/{id}/inactive")
	public ElectionPositionResponse inactivePositionElection(@PathVariable final long id) {
		return ElectionPositionResponse.build(electionPositionService.setActive(id, false));

	}	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final Long id) {
		electionPositionService.deleteElectionPosition(id);
		return "ElectionPosition entry deleted successfully";
	}
	
	@GetMapping("/fetch/{id}")
	public ElectionPositionResponse fetch(@PathVariable final Long id) {
		return ElectionPositionResponse.build(electionPositionService.getElectionPosition(id));
	}
	
	@GetMapping("/")
	public List<ElectionPositionResponse> fetchAll() {
		return electionPositionService.getAll()
				.stream()
				.map(inc -> ElectionPositionResponse.build(inc))
				.collect(Collectors.toList());
	}
}
