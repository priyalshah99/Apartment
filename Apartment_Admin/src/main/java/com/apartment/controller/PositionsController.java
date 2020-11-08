package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.service.PositionsService;

@RestController
@RequestMapping("/positions")
@CrossOrigin(origins="http://localhost:4200")
public class PositionsController {
	
	@Autowired
	private PositionsService positionService;
}