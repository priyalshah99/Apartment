package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.MaintenanceRequest;
import com.apartment.response.MaintenanceResponse;
import com.apartment.response.NonpaidMaintainenaceResponse;
import com.apartment.service.MaintenanceService;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin(origins="http://localhost:4200")
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;
	
	@PostMapping("/")
	public String addMaintenanceEntry(@RequestBody MaintenanceRequest request) {
		maintenanceService.saveEntry(request);
		return "Maintenance entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateMaintenanceEntry(@PathVariable final Long id, @RequestBody final MaintenanceRequest request) {
		maintenanceService.saveEntry(id, request);
		return "Maintenance entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteMaintenanceEntry(@PathVariable final Long id) {
		maintenanceService.deleteEntry(id);
		return "Maintenance entry deleted successfully";
	}
	
	@GetMapping("/fetch/{id}")
	public MaintenanceResponse getMaintenance(@PathVariable final Long id) {
		return MaintenanceResponse.build(maintenanceService.fetch(id));
	}
	
	@GetMapping("/")
	public List<MaintenanceResponse> fetchAll() {
		return maintenanceService.fetchAll()
				.stream()
				.map(inc -> MaintenanceResponse.build(inc))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/nonpaid")
	public List<NonpaidMaintainenaceResponse> fetchFlatsNotPaidMaintenenace() {
		return maintenanceService.fetchFlatsWithMaintenanceNotPaid()
				.stream()
				.map(flat -> NonpaidMaintainenaceResponse.build(flat))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/fetchbyflat/{id}")
	public List<MaintenanceResponse> fetchByFlat(@PathVariable final int id) {
	
		return maintenanceService.getAllByFlats(id)
				.stream()
				.map(inc -> MaintenanceResponse.build(inc))
				.collect(Collectors.toList());
	
	}
}
