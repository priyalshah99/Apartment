package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionPositionRequest {

	private String positionName;
	private boolean active;
	
	/*
	 * { "positionName":"Secretary",
	 * "active":"true" }
	 */
}
