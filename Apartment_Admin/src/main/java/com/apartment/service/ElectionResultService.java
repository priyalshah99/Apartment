package com.apartment.service;

import java.util.List;

import com.apartment.models.ElectionResult;
import com.apartment.request.ElectionResultRequest;

public interface ElectionResultService {

void saveElectionResult(final ElectionResultRequest electionResultRequest);
	
	void updateElectionResult(final Long id, final ElectionResultRequest electionResultRequest);
	
	List<ElectionResult> getAll();
	
	ElectionResult getElectionResult(final Long id);
	
	void deleteElectionResult(final Long id);
	
	List<ElectionResult> getAllByElection(Long id);
	
	public int upvote(Long id);
}
