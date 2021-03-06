package com.apartment.service;

import java.util.List;

import com.apartment.models.EmployeePosition;
import com.apartment.request.EmployeePositionRequest;

public interface EmployeePositionService {

	void save(final EmployeePositionRequest empPositionRequest);
	
	void save(final Long id, final EmployeePositionRequest empPositionRequest);
	
	List<EmployeePosition> fetchAll();
	
	EmployeePosition fetch(final Long id);
	
	Long findByName(final String name);
	
	EmployeePosition fetchEmployeePosition(final Long id);

}
