package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.FundsRepo;
import com.apartment.service.FundsService;

@Service
public class FundsServiceImpl implements FundsService {

	@Autowired
	private FundsRepo fundsRepo;
}