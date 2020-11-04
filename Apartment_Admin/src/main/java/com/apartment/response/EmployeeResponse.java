package com.apartment.response;

import com.apartment.models.EmployeeDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

	private Long employeeId;
	private String name;
	private String contact;
	private String address;
	private boolean active;
	private String position;
	
	public static EmployeeResponse build(EmployeeDetails employee) {
		EmployeeResponse empResponse = new EmployeeResponse();
		empResponse.setEmployeeId(employee.getEmployeeId());
		empResponse.setName(employee.getName());
		empResponse.setContact(employee.getContact());
		empResponse.setAddress(employee.getAddress());
		empResponse.setActive(employee.isActive());
		empResponse.setPosition(employee.getEmployeePosition().getPositionName());
		return empResponse;
	}
}
