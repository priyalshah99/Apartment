package com.apartment.service;

import java.util.List;

import com.apartment.models.ElectionVoteRecord;

public interface ElectionVoteRecordService {
	void save(Long electionResultId, Long ownerId);

	List<ElectionVoteRecord> get(Long ownerId);
}
