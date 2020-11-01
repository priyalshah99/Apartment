package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.repo.MaintenanceRepo;
import com.apartment.service.MaintenanceService;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private MaintenanceRepo maintenanceRepo;
}
