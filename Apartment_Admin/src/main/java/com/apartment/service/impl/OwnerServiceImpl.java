package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Owner;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.LoginRequest;
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
		owner.setActive(ownerRequest.isActive());
		owner.setPassword(ownerRequest.getPassword());
		
		ownerRepo.save(owner);
		
	}

	@Override
	public void updateOwner(Long id, OwnerRequest ownerRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Owner owner = ownerRepo.getOne(id);
		owner.setName(ownerRequest.getName());
		owner.setContactNo(ownerRequest.getContactNo());
		owner.setEmail(ownerRequest.getEmail());
		owner.setDateOfPurchase(LocalDate.parse(ownerRequest.getDateOfPurchase(),formatter));
		owner.setActive(ownerRequest.isActive());
		owner.setPassword(ownerRequest.getPassword());
		
		ownerRepo.save(owner);
	}
	
	@Override
	public Owner setActive(Long id, boolean active) {
		Owner owner = ownerRepo.getOne(id);
		owner.setActive(active);
		ownerRepo.save(owner);
		return owner;
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
	
	@Override
	public List<Owner> getInactiveOwner() {
		return ownerRepo.findByActiveFalse();
	}

	@Override
	public List<Owner> getActiveOwner() {
		return ownerRepo.findByActiveTrue();
	}

	@Override
	public Owner findByEmail(String email) {
		 return ownerRepo.findFirstByEmail(email);
		
	}

	@Override
	public Owner checkByEmailAndPassword(LoginRequest loginRequest) {
		Owner owner=ownerRepo.findFirstByEmail(loginRequest.getEmail());
		if(owner!=null && loginRequest.getPassword().equals(owner.getPassword()))
			return owner;
		else 
			return null;
	}
}
