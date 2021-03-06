package com.apartment.service;

import java.util.List;

import com.apartment.models.EmployeeDetails;
import com.apartment.request.EmployeeDetailsRequest;

public interface EmployeeDetailsService {
	
	void saveEmployee(final EmployeeDetailsRequest empRequest);
	
	void saveEmployee(final Long id, final EmployeeDetailsRequest empRequest);
	
	EmployeeDetails setActive(final Long id, final boolean active);
	
	EmployeeDetails fetch(final Long id);
	
	List<EmployeeDetails> fetchAll();

}
