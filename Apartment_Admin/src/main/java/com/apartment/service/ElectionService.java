package com.apartment.service;

import java.util.List;

import com.apartment.models.Election;
import com.apartment.request.ElectionRequest;

public interface ElectionService {

	
	void saveElection(final ElectionRequest electionRequest);
	
	void updateElection(final Long id, final ElectionRequest electionRequest);
	
	List<Election> getAll();
	
	Election getElection(final Long id);
	
	void deleteElection(final Long id);
}
