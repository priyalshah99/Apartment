package com.apartment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Owner;
import com.apartment.notification.Email;
import com.apartment.notification.EmailSenderService;
import com.apartment.notification.PasswordRecoveryTextBuilder;
import com.apartment.repo.OwnerRepo;
import com.apartment.service.PasswordRecoveryService;
import com.apartment.utils.RandomNumber;

@Service
public class PasswordRecoveryServiceImpl implements PasswordRecoveryService{
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private EmailSenderService emailSender;
	
	@Override
	public void sendRecoveryEmail(final long ownerId) {
		Owner owner = ownerRepo.getOne(ownerId);
		String tempPassword = RandomNumber.getNext();
		owner.setPassword(tempPassword);
		ownerRepo.save(owner);
		String emailBody = PasswordRecoveryTextBuilder.buildBody(owner.getName(), tempPassword);
		Email email = new Email();
		email.setBody(emailBody);
		email.setSubject(PasswordRecoveryTextBuilder.getSubject());
		email.setTo(owner.getEmail());
		emailSender.send(email);
	}

}
