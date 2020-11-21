package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.ElectionPositionRepo;
import com.apartment.service.ElectionPositionService;

@Service
public class ElectionPositionServiceImpl implements ElectionPositionService {

	@Autowired
	private ElectionPositionRepo electionPositionRepo;
}
