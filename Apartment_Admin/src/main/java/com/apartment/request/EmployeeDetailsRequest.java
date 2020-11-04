package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetailsRequest {
	
	private String name;
	private String contact;
	private String address;
    private Long employeePositionId;
    private boolean active;
}

/*
{
	"name":"Haribhai",
	"contact":"9878878787",
	"address":"15,MG Road,Vasna",
	"employeePositionId":1,
	"active":true
}
 */
