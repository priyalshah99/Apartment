package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePositionRequest {
	private String positionName;
	private double salary;
	private String responsibilities;
}

/*
{
	"positionName":"sweeper",
	"salary":5000,
	"responsibilities":"ACD block"
}
 */