package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.ComplaintsRepo;
import com.apartment.service.ComplaintsService;

@Service
public class ComplaintsServiceImpl implements ComplaintsService{

	@Autowired
	private ComplaintsRepo complaintsRepo;
}
