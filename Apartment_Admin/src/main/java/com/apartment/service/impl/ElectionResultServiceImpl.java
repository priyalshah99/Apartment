package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Election;
import com.apartment.models.ElectionResult;
import com.apartment.repo.ElectionPositionRepo;
import com.apartment.repo.ElectionRepo;
import com.apartment.repo.ElectionResultRepo;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.ElectionResultRequest;
import com.apartment.service.ElectionResultService;

@Service
public class ElectionResultServiceImpl implements ElectionResultService{

	@Autowired
	private ElectionResultRepo electionResultRepo;
	
	@Autowired
	private ElectionRepo electionRepo;
	
	@Autowired
	private ElectionPositionRepo electionPositionRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public void saveElectionResult(ElectionResultRequest electionResultRequest) {

		ElectionResult electionResult=new ElectionResult();
		
		electionResult.setOwner(ownerRepo.getOne(electionResultRequest.getOwnerId()));
		electionResult.setElection(electionRepo.getOne(electionResultRequest.getElectionId()));
		electionResult.setElectionPosition(electionPositionRepo.getOne(electionResultRequest.getPositionId()));
		
		electionResult.setVoteCount(electionResultRequest.getVoteCount());
		electionResult.setWinner(electionResultRequest.isWinner());
		
		electionResultRepo.save(electionResult);
	}

	@Override
	public void updateElectionResult(Long id, ElectionResultRequest electionResultRequest) {

		ElectionResult electionResult=electionResultRepo.getOne(id);
		
		electionResult.setOwner(ownerRepo.getOne(electionResultRequest.getOwnerId()));
		electionResult.setElection(electionRepo.getOne(electionResultRequest.getElectionId()));
		electionResult.setElectionPosition(electionPositionRepo.getOne(electionResultRequest.getPositionId()));
		
		electionResult.setVoteCount(electionResultRequest.getVoteCount());
		electionResult.setWinner(electionResultRequest.isWinner());
		
		electionResultRepo.save(electionResult);
	}

	@Override
	public List<ElectionResult> getAll() {		
		return electionResultRepo.findAll();
	}

	@Override
	public ElectionResult getElectionResult(Long id) {
		return electionResultRepo.getOne(id);
	}

	@Override
	public void deleteElectionResult(Long id) {
		electionResultRepo.deleteById(id);
	}

	@Override
	public List<ElectionResult> getAllByElection(Long id) {
		Election e=electionRepo.getOne(id);
		return electionResultRepo.findByElection(e);
	}
	
	
}
