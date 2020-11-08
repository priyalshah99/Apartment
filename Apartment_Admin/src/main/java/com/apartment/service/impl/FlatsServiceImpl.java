package com.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Flats;
import com.apartment.repo.FlatsRepo;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.FlatsRequest;
import com.apartment.service.FlatsService;

@Service
public class FlatsServiceImpl implements FlatsService {

	@Autowired
	private FlatsRepo flatsRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;


	@Override
	public void saveFlat(FlatsRequest flatRequest) {
		Flats flat = new Flats();
		flat.setFlatNo(flatRequest.getFlatNo());
		flat.setBhk(flatRequest.getBhk());
		flat.setParkingSlot(flatRequest.getParkingSlot());
		flat.setOccupied(false);
	//	flat.setOwner(ownerRepo.getOne(flatRequest.getOwnerId()));
		
		flatsRepo.save(flat);
	}

	@Override
	public List<Flats> getEmptyFlats() {
		return flatsRepo.findByOccupiedFalse();
	}

	@Override
	public List<Flats> getOccupiedFlats() {
		return flatsRepo.findByOccupiedTrue();
	}

	@Override
	public List<Flats> getAllFlats() {
		return flatsRepo.findAll();
	}
	
	
}