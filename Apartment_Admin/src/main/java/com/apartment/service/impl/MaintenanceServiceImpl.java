package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Flats;
import com.apartment.models.Maintenance;
import com.apartment.repo.FlatsRepo;
import com.apartment.repo.MaintenanceRepo;
import com.apartment.request.MaintenanceRequest;
import com.apartment.service.MaintenanceService;
import com.apartment.utils.Constants;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

	@Autowired
	private MaintenanceRepo maintenanceRepo;
	
	@Autowired
	private FlatsRepo flatsRepo;

	@Override
	public void saveEntry(MaintenanceRequest request) {
		Maintenance maintenance = new Maintenance();
		maintenance.setAmount(request.getAmount());
		maintenance.setDate(LocalDate.parse(request.getDate(),formatter));
		maintenance.setMonth(request.getMonth());
		maintenance.setPaymentMode(request.getPaymentMode());
		maintenance.setFlat(flatsRepo.findFirstByFlatNo(request.getFlatNo()));
		
		maintenanceRepo.save(maintenance);
	}

	@Override
	public void saveEntry(Long id, MaintenanceRequest request) {
		
		Maintenance maintenance = maintenanceRepo.getOne(id);
		maintenance.setAmount(request.getAmount());
		maintenance.setDate(LocalDate.parse(request.getDate(),formatter));
		maintenance.setMonth(request.getMonth());
		maintenance.setPaymentMode(request.getPaymentMode());
		maintenance.setFlat(flatsRepo.findFirstByFlatNo(request.getFlatNo()));
		
		maintenanceRepo.save(maintenance);		
	}

	@Override
	public void deleteEntry(Long id) {
		maintenanceRepo.deleteById(id);
	}

	@Override
	public Maintenance fetch(Long id) {
		
		return maintenanceRepo.getOne(id);
	}

	@Override
	public List<Maintenance> fetchAll() {
		
		return maintenanceRepo.findAll();
	}
	
	
	@Override
	public List<Flats> fetchFlatsWithMaintenanceNotPaid() {
		int month = LocalDate.now().getMonth().getValue();
		return maintenanceRepo.findFlatsWithNoMaintenancePaid(month);
	}
	
	@Override
	public List<Maintenance> getAllByFlats(int id) {
		Flats f=flatsRepo.getOne(id);
		return maintenanceRepo.findByFlat(f);
	}
}
