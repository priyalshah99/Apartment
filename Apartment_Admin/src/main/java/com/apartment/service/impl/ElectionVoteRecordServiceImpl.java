package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.ElectionVoteRecord;
import com.apartment.repo.ElectionResultRepo;
import com.apartment.repo.ElectionVoteRecordRepo;
import com.apartment.repo.OwnerRepo;
import com.apartment.service.ElectionVoteRecordService;

@Service
public class ElectionVoteRecordServiceImpl implements ElectionVoteRecordService {

	@Autowired
	private ElectionVoteRecordRepo electionVoteRecordRepo;
	
	@Autowired
	private ElectionResultRepo electionResultRepo;
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Override
	public void save(Long electionResultId, Long ownerId) {

		ElectionVoteRecord evr=new ElectionVoteRecord();
		evr.setElection(electionResultRepo.getOne(electionResultId));
		evr.setMember(ownerRepo.getOne(ownerId));
		electionVoteRecordRepo.save(evr);
	}
	
	@Override
	public List<ElectionVoteRecord> get(Long ownerId)
	{
		return electionVoteRecordRepo.findByMember(ownerRepo.getOne(ownerId));
	}

}
