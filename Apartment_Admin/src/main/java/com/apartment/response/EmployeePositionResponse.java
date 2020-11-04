package com.apartment.response;

import com.apartment.models.EmployeePosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePositionResponse {
	private Long employeePositionId;
	private String positionName;
	private double salary;
	private String responsibilities;
	
	public static EmployeePositionResponse build(final EmployeePosition empPosition) {
		EmployeePositionResponse empPositionResponse = new EmployeePositionResponse();
		empPositionResponse.setEmployeePositionId(empPosition.getEmployeePositionId());
		empPositionResponse.setPositionName(empPosition.getPositionName());
		empPositionResponse.setSalary(empPosition.getSalary());
		empPositionResponse.setResponsibilities(empPosition.getResponsibilities());
		
		return empPositionResponse;
	}

}
