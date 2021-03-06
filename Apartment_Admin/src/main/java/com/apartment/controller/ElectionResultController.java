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

import com.apartment.request.ElectionResultRequest;
import com.apartment.response.ElectionResultResponse;
import com.apartment.service.ElectionResultService;

@RestController
@RequestMapping("/electionResult")
@CrossOrigin(origins="http://localhost:4200")
public class ElectionResultController {

	
	@Autowired
	private ElectionResultService electionResultService;
	
	@PostMapping("/")
	public String add(@RequestBody ElectionResultRequest request) {
		electionResultService.saveElectionResult(request);
		return "ElectionResult entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable final Long id, @RequestBody final ElectionResultRequest request) {
		electionResultService.updateElectionResult(id, request);
		return "ElectionResult entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable final Long id) {
		electionResultService.deleteElectionResult(id);
		return "ElectionResult entry deleted successfully";
	}
	
	@GetMapping("/fetch/{id}")
	public ElectionResultResponse fetch(@PathVariable final Long id) {
		return ElectionResultResponse.build(electionResultService.getElectionResult(id));
	}
	
	@GetMapping("/")
	public List<ElectionResultResponse> fetchAll() {
		return electionResultService.getAll()
				.stream()
				.map(inc -> ElectionResultResponse.build(inc))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/fetchbyelection/{id}")
	public List<ElectionResultResponse> fetchByElection(@PathVariable final Long id) {
	
		return electionResultService.getAllByElection(id)
				.stream()
				.map(inc -> ElectionResultResponse.build(inc))
				.collect(Collectors.toList());
	
	}
	
	@PutMapping("/{id}/upvote/")
	public int upvote(@PathVariable final long id) {
		return electionResultService.upvote(id);
	}
	
}
