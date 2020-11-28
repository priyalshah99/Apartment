package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionResultRequest {

	private int voteCount;
	//private boolean winner;	
    private Long ownerId;
	private Long PositionId;	
    private Long electionId;
    
    
	/*
	 * { "ownerId":2,
	 *  "positionId":1,
	 *   "electionId":1,
	 *    "voteCount":40
	 *     
	 * }
	 */
}
