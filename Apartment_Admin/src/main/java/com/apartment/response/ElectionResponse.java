package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Election;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ElectionResponse {
	
	
		private Long id;
		private String date;
		
		private String electionName;
		private boolean active;
		private String endDate;
		
		
		public static ElectionResponse build(final Election election) {
			ElectionResponse electionResponse = new ElectionResponse();
			electionResponse.setId(election.getElectionId());
			electionResponse.setDate(election.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			electionResponse.setElectionName(election.getElectionName());
			electionResponse.setActive(election.isActive());
			electionResponse.setEndDate(election.getEndDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			
			return electionResponse;
		}
}
