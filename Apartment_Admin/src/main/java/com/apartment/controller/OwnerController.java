package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.OwnerRequest;
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
}