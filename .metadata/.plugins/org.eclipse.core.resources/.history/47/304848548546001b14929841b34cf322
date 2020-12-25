package com.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.service.PasswordRecoveryService;

@RestController
public class PasswordRecoveryController {

	@Autowired
	private PasswordRecoveryService passwordRecoveryService;
	
	@GetMapping("/password/recovery/{id}")
	public String recoverPassword(@PathVariable final Long id) {
		passwordRecoveryService.sendRecoveryEmail(id);
		return "Password recovery email is sent to your registered email address";
	}
	
}
