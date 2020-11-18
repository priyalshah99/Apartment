package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Owner;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.OwnerRequest;
import com.apartment.service.OwnerService;
import com.apartment.utils.Constants;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public void saveOwner(OwnerRequest ownerRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Owner owner = new Owner();
		owner.setName(ownerRequest.getName());
		owner.setContactNo(ownerRequest.getContactNo());
		owner.setEmail(ownerRequest.getEmail());
		owner.setDateOfPurchase(LocalDate.parse(ownerRequest.getDateOfPurchase(),formatter));
		
		ownerRepo.save(owner);
		
	}

	@Override
	public void updateOwner(Long id, OwnerRequest ownerRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Owner owner = new Owner();
		owner.setName(ownerRequest.getName());
		owner.setContactNo(ownerRequest.getContactNo());
		owner.setEmail(ownerRequest.getEmail());
		owner.setDateOfPurchase(LocalDate.parse(ownerRequest.getDateOfPurchase(),formatter));
		
		ownerRepo.save(owner);
	}

	@Override
	public void deleteOwner(Long id) {
		ownerRepo.deleteById(id);		
	}

	@Override
	public Owner fetchOwner(Long id) {
		return ownerRepo.getOne(id);
	}

	@Override
	public List<Owner> fetchAll() {
		return ownerRepo.findAll();
	}
}
