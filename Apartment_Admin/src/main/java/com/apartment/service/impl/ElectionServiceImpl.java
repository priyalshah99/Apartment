package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Election;
import com.apartment.repo.ElectionRepo;
import com.apartment.request.ElectionRequest;
import com.apartment.service.ElectionService;
import com.apartment.utils.Constants;

@Service
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionRepo electionRepo;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
	
	
	@Override
	public void saveElection(ElectionRequest electionRequest) {
		
		Election election=new Election();
		
		election.setElectionName(electionRequest.getElectionName());		
		election.setDate(LocalDate.parse(electionRequest.getDate(),formatter));	
		election.setActive(electionRequest.isActive());
		election.setEndDate(LocalDate.parse(electionRequest.getEndDate(),formatter));	
		
		electionRepo.save(election);
		
	}

	@Override
	public void updateElection(Long id, ElectionRequest electionRequest) {

		Election election=electionRepo.getOne(id);
		
		election.setElectionName(electionRequest.getElectionName());		
		election.setDate(LocalDate.parse(electionRequest.getDate(),formatter));		
		election.setActive(electionRequest.isActive());
		election.setEndDate(LocalDate.parse(electionRequest.getEndDate(),formatter));	
		
		electionRepo.save(election);
	}
	
	@Override
	public Election setActive(Long id, boolean active) {
		Election election = electionRepo.getOne(id);
		election.setActive(active);
		electionRepo.save(election);
		return election;
	}

	@Override
	public List<Election> getAll() {
		return electionRepo.findAll();
	}

	@Override
	public Election getElection(Long id) {
		return electionRepo.getOne(id);
	}

	@Override
	public void deleteElection(Long id) {
		electionRepo.deleteById(id);
	}
	
	@Override
	public List<Election> fetchElection(final String state) {
		if(state.equalsIgnoreCase(Constants.UPCOMING)) {
			return electionRepo.findByDateAfter(LocalDate.now());
		} else if(state.equalsIgnoreCase(Constants.COMPLETED)) {
			return electionRepo.findByEndDateBefore(LocalDate.now());
		}
		return electionRepo.findAll();
	}
}
