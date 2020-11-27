package com.apartment.response;

import com.apartment.models.ElectionPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionPositionResponse {

	private String name;
	private Long id;
	
	public static ElectionPositionResponse build(final ElectionPosition electionPosition) {
	
		ElectionPositionResponse response=new ElectionPositionResponse();
		
		response.setId(electionPosition.getPositionId());
		response.setName(electionPosition.getPositionName());
		
		
		return(response);
		
		
	}
}
