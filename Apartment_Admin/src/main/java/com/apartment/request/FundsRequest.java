package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundsRequest {

	private double amount;
	private String date;
	private String reason;
	private String paymentMode;
	private Long ownerId;
}
