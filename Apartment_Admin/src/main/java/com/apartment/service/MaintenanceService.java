package com.apartment.service;

import java.util.List;

import com.apartment.models.Flats;
import com.apartment.models.Maintenance;
import com.apartment.request.MaintenanceRequest;

public interface MaintenanceService {
	
	void saveEntry(final MaintenanceRequest request);
	
	void saveEntry(final Long id,final MaintenanceRequest request);
	
	void deleteEntry(final Long id);
	
	Maintenance fetch(final Long id);
	
	List<Maintenance> fetchAll();
	
	List<Flats> fetchFlatsWithMaintenanceNotPaid();

	List<Maintenance> getAllByFlats(int id);
}
