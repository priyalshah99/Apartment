package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Maintenance;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceResponse {
	private Long id;
	private double amount;
	private String date;
	private String month;
	private String paymentMode;
    private String flatNo;
    
    public static MaintenanceResponse build(final Maintenance maintenance) {
    	MaintenanceResponse response = new MaintenanceResponse();
    	response.setId(maintenance.getMaintenanceId());
    	response.setAmount(maintenance.getAmount());
    	response.setDate(maintenance.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
    	response.setMonth(maintenance.getMonth());
    	response.setPaymentMode(maintenance.getPaymentMode());
    	response.setFlatNo(maintenance.getFlat().getFlatNo());
    	return response;
    }
}
