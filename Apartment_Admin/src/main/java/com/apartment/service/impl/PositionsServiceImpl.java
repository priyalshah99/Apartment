package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.PositionsRepo;
import com.apartment.service.PositionsService;

@Service
public class PositionsServiceImpl implements PositionsService {

	@Autowired
	private PositionsRepo positionsRepo;
}
