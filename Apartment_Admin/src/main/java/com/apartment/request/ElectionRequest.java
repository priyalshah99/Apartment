package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionRequest {

	private String date;
	private String electionName;
	private boolean active;
	private String endDate;
	
	/*
	 * { "date":"12/12/2020",
	 *  "electionName":"Election2020",
	 *  "active":true,
	 *  "endDate":"14/12/2020"
	 *   }
	 */
}
