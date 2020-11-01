package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Owner;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.OwnerRequest;
import com.apartment.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public void saveOwner(OwnerRequest ownerRequest) {
		Owner owner = new Owner();
		owner.setName(ownerRequest.getName());
		owner.setContactNo(ownerRequest.getContactNo());
		owner.setEmail(ownerRequest.getEmail());
		
		ownerRepo.save(owner);
		
	}
}
