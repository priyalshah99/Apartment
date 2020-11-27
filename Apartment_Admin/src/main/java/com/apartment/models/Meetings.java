package com.apartment.models;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Meetings {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long meetingId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String topic;
	private String agenda;
	private String minutesOfMeeting;
	private boolean active;

}
