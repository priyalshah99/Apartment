package com.apartment.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
	private String subject;
	private String body;
	private String to;
	private String cc;
}
