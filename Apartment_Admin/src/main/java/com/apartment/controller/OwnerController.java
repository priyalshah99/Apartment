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

import com.apartment.models.Owner;
import com.apartment.request.LoginRequest;
import com.apartment.request.OwnerRequest;
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
	
	@PutMapping("/{id}/active")
	public OwnerResponse activeOwner(@PathVariable final long id) {
		return OwnerResponse.build(ownerService.setActive(id, true));
		
	}
	
	@PutMapping("/{id}/inactive")
	public OwnerResponse inactiveOwner(@PathVariable final long id) {
		return OwnerResponse.build(ownerService.setActive(id, false));

	}	
	
	@DeleteMapping("/{id}")
	public String deleteOwner(@PathVariable final Long id) {
		ownerService.deleteOwner(id);
		return "Owner deleted successfully";
	}
	
	@GetMapping("/{id}")
	public OwnerResponse getOwner(@PathVariable final Long id) {
		return OwnerResponse.build(ownerService.fetchOwner(id));
	}
	
	@GetMapping("/")
	public List<OwnerResponse> fetchAll() {
		return ownerService.fetchAll()
				.stream()
				.map(inc -> OwnerResponse.build(inc))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/active")
	public List<OwnerResponse> fetchActive() {
		return ownerService.getActiveOwner().stream().map(flt->OwnerResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/inactive")
	public List<OwnerResponse> fetchInactive() {
		return ownerService.getInactiveOwner().stream().map(flt->OwnerResponse.build(flt)).collect(Collectors.toList());
	}
	
	@GetMapping("/byemail/{email}")
	public OwnerResponse getIdFromEmail(@PathVariable final String email) {
		return OwnerResponse.build(ownerService.findByEmail(email));
	}
	
	@PostMapping("/login")
	public OwnerResponse checkEmailAndPassword(@RequestBody final LoginRequest loginRequest) {
		Owner owner = ownerService.checkByEmailAndPassword(loginRequest);
		return owner==null?null:OwnerResponse.build(owner);
	}
	
}
