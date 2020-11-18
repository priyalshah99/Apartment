package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Funds;
import com.apartment.models.Maintenance;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundsResponse {
	
	private double amount;
	private String date;
	private String reason;
	private String paymentMode;
	private Long ownerId;
	private String ownerName;
	
	public static FundsResponse build(final Funds funds) {
		FundsResponse response = new FundsResponse();
		
		response.setAmount(funds.getAmount());
		response.setDate(funds.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		response.setPaymentMode(funds.getPaymentMode());
		response.setReason(funds.getReason());
		response.setOwnerId(funds.getOwner().getOwnerId());
		response.setOwnerName(funds.getOwner().getName());
		
    	return response;
	}
}
