package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.EmployeePosition;

@Repository
public interface EmployeePositionRepo extends JpaRepository<EmployeePosition,Long> {

	EmployeePosition findFirstByPositionName(final String name);
	
}
