package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.ElectionResult;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionResultResponse {

	private Long electionResultId;
	private Long ownerId;
	private String ownerName;
	
	private Long positionId;
	private String positionName;
	
	private Long electionId;
	private String electionName;
	private String electionDate;
	
	private int voteCount;
//	private boolean winner;
	
	public static ElectionResultResponse build(final ElectionResult electionResult) {
		ElectionResultResponse response = new ElectionResultResponse();
		response.setElectionResultId(electionResult.getElectionResultId());
		response.setOwnerId(electionResult.getOwner().getOwnerId());
		response.setOwnerName(electionResult.getOwner().getName());
		
		response.setPositionId(electionResult.getElectionPosition().getPositionId());
		response.setPositionName(electionResult.getElectionPosition().getPositionName());
		
		response.setElectionId(electionResult.getElection().getElectionId());
		response.setElectionName(electionResult.getElection().getElectionName());
		response.setElectionDate(electionResult.getElection().getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
				
		response.setVoteCount(electionResult.getVoteCount());
	//	response.setWinner(electionResult.isWinner());
		return response;
	}
	
}
