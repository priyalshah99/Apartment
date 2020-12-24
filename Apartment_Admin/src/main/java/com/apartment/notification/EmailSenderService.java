package com.apartment.notification;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String senderEmailAddress;

	public void send(final Email email) {
		try {
			MimeMessage message = emailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(senderEmailAddress);
			helper.setTo(email.getTo());
			helper.setSubject(email.getSubject());
			helper.setText(email.getBody(), true);
			emailSender.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
