package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Salary;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryResponse {

	private Long salaryId;
	private String datePaid;
	private double amountPaid;
	private int noOfLeaves;	
    private Long employeeId;
    private String employeeName;
    
    public static SalaryResponse build(final Salary salary) {
    
    	SalaryResponse response=new SalaryResponse();
    	
    	response.setSalaryId(salary.getSalaryId());
    	response.setDatePaid(salary.getDatePaid().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
    	response.setAmountPaid(salary.getAmountPaid());
    	response.setNoOfLeaves(salary.getNoOfLeaves());
    	
    	response.setEmployeeId(salary.getEmployeeDetails().getEmployeeId());
    	response.setEmployeeName(salary.getEmployeeDetails().getName());
    	
    	return(response);
    	
    }
}
