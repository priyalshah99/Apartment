package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.ElectionPosition;
import com.apartment.repo.ElectionPositionRepo;
import com.apartment.request.ElectionPositionRequest;
import com.apartment.service.ElectionPositionService;

@Service
public class ElectionPositionServiceImpl implements ElectionPositionService {

	
	
	@Autowired
	private ElectionPositionRepo electionPositionRepo;

	
	
	@Override
	public void saveElectionPosition(ElectionPositionRequest electionPositionRequest) {
		
		ElectionPosition electionPosition=new ElectionPosition();
		
		electionPosition.setPositionName(electionPositionRequest.getPositionName());		
		electionPosition.setActive(electionPositionRequest.isActive());
		
		electionPositionRepo.save(electionPosition);
		
	}

	@Override
	public void updateElectionPosition(Long id, ElectionPositionRequest electionPositionRequest) {

		ElectionPosition electionPosition=electionPositionRepo.getOne(id);
		
		electionPosition.setPositionName(electionPositionRequest.getPositionName());
		electionPosition.setActive(electionPositionRequest.isActive());
		
		electionPositionRepo.save(electionPosition);
	}
	
	@Override
	public ElectionPosition setActive(Long id, boolean active) {
		ElectionPosition electionPosition = electionPositionRepo.getOne(id);
		electionPosition.setActive(active);
		electionPositionRepo.save(electionPosition);
		return electionPosition;
	}

	@Override
	public List<ElectionPosition> getAll() {
		return electionPositionRepo.findAll();
	}

	@Override
	public ElectionPosition getElectionPosition(Long id) {
		return electionPositionRepo.getOne(id);
	}

	@Override
	public void deleteElectionPosition(Long id) {
		electionPositionRepo.deleteById(id);
	}
}
