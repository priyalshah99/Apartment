package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Funds;
import com.apartment.repo.FundsRepo;
import com.apartment.request.FundsRequest;
import com.apartment.service.FundsService;

@Service
public class FundsServiceImpl implements FundsService {

	@Autowired
	private FundsRepo fundsRepo;
	//amt,date,reason,mode,owner

	@Override
	public void saveFunds(FundsRequest fundsRequest) {
		
	}

	@Override
	public void updateFunds(Long id, FundsRequest fundsRequest) {
		
	}

	@Override
	public List<Funds> getAll() {
		return fundsRepo.findAll();
	}

	@Override
	public Funds getFunds(Long id) {
		return fundsRepo.getOne(id);
	}

	@Override
	public void deleteFunds(Long id) {
		fundsRepo.deleteById(id);
		
	}
	
	
}
