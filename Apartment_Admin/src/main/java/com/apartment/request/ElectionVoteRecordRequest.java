package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionVoteRecordRequest {
	private Long electionResultId;
	private Long memberId;
}
