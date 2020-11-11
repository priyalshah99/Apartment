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

import com.apartment.request.MeetingRequest;
import com.apartment.request.OwnerRequest;
import com.apartment.response.IncomeResponse;
import com.apartment.response.MeetingResponse;
import com.apartment.response.OwnerResponse;
import com.apartment.service.OwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins="http://localhost:4200")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/")
	public String addOwner(@RequestBody final OwnerRequest ownerRequest) {
		ownerService.saveOwner(ownerRequest);
		return "Owner added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateOwner(@PathVariable final Long id,@RequestBody OwnerRequest request) {
		ownerService.updateOwner(id, request);
		return "Owner updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteOwner(@PathVariable final Long id) {
		ownerService.deleteOwner(id);
		return "Owner deleted successfully";
	}
	
	@GetMapping("/{id}")
	public OwnerResponse getMeeting(@PathVariable final Long id) {
		return OwnerResponse.build(ownerService.fetchOwner(id));
	}
	
	@GetMapping("/")
	public List<OwnerResponse> fetchAll() {
		return ownerService.fetchAll()
				.stream()
				.map(inc -> OwnerResponse.build(inc))
				.collect(Collectors.toList());
	}
}
