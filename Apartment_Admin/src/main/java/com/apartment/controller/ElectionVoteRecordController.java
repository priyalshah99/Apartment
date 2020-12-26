package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.models.ElectionVoteRecord;
import com.apartment.request.ElectionVoteRecordRequest;
import com.apartment.response.ElectionVoteRecordResponse;
import com.apartment.service.ElectionVoteRecordService;

@RestController
@RequestMapping("/electionVoteRecord")
@CrossOrigin(origins="http://localhost:4200")
public class ElectionVoteRecordController {
	
	@Autowired
	private ElectionVoteRecordService voteRecordService;

	@PostMapping("/vote")
	public String vote(@RequestBody final ElectionVoteRecordRequest request) {
		voteRecordService.save(request.getElectionResultId(), request.getMemberId());
		return "Election vote record saved successfully";
	}
	
	@GetMapping("/vote/{id}")
	public List<ElectionVoteRecordResponse> get(@PathVariable final long id) {
		List<ElectionVoteRecord> record = voteRecordService.get(id);
		return record==null?null:voteRecordService.get(id).stream()
				.map(inc -> ElectionVoteRecordResponse.build(inc))
				.collect(Collectors.toList());
			//ElectionVoteRecordResponse.build(record);
	}
	
	
	
}
