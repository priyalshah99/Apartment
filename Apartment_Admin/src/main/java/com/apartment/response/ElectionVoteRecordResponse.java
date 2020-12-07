package com.apartment.response;

import com.apartment.models.ElectionVoteRecord;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionVoteRecordResponse {
	private Long voteId;
	private Long electionResultId;
	private Long ownerId;
	
	public static ElectionVoteRecordResponse build(ElectionVoteRecord record) {
		ElectionVoteRecordResponse response = new ElectionVoteRecordResponse();
		response.setVoteId(record.getVoteId());
		response.setElectionResultId(record.getElection().getElectionResultId());
		response.setOwnerId(record.getMember().getOwnerId());
		return response;
	}
}
