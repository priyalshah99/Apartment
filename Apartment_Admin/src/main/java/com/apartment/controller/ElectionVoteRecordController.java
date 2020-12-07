package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.models.ElectionVoteRecord;
import com.apartment.request.ElectionVoteRecordRequest;
import com.apartment.response.ElectionVoteRecordResponse;
import com.apartment.service.ElectionVoteRecordService;

@RestController
public class ElectionVoteRecordController {
	
	@Autowired
	private ElectionVoteRecordService voteRecordService;

	@PostMapping("/vote")
	public String vote(@RequestBody final ElectionVoteRecordRequest request) {
		voteRecordService.save(request.getElectionResultId(), request.getMemberId());
		return "Election vote record saved successfully";
	}
	
	@GetMapping("/vote")
	public ElectionVoteRecordResponse get(@RequestParam(name="electionResultId") final Long electionResultId, @RequestParam(name="ownerId") final Long ownerId) {
		ElectionVoteRecord record = voteRecordService.get(electionResultId, ownerId);
		return record==null?null:ElectionVoteRecordResponse.build(record);
	}
}
