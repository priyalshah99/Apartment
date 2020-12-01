package com.apartment.service;

import java.util.List;

import com.apartment.models.ElectionPosition;
import com.apartment.request.ElectionPositionRequest;

public interface ElectionPositionService {

	void saveElectionPosition(final ElectionPositionRequest electionPositionRequest);
	
	void updateElectionPosition(final Long id, final ElectionPositionRequest electionPositionRequest);
	
	List<ElectionPosition> getAll();
	
	ElectionPosition getElectionPosition(final Long id);
	
	void deleteElectionPosition(final Long id);
	
	ElectionPosition setActive(final Long id, final boolean active);
}
