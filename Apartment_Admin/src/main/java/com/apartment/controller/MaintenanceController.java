package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.MaintenanceRequest;
import com.apartment.service.MaintenanceService;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin(origins="http://localhost:4200")
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;
	
	@PostMapping("/")
	public String addMaintenanceEntry(@RequestBody MaintenanceRequest request) {
		return "Maintenance entry added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateMaintenanceEntry(@PathVariable final Long id, @RequestBody final MaintenanceRequest request) {
		return "Maintenance entry updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteMaintenanceEntry(@PathVariable final Long id) {
		return "Maintenance entry deleted successfully";
	}
}
