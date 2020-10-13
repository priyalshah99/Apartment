package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingRequest {
	private String startTime;
	private String endTime;
	private String topic;
	private String agenda;
	private String minutesOfMeeting;
}
/*
 {
	"startTime" : "13/10/2020 03:00:00",
	"endTime" : "13/10/2020 04:00:00",
	"topic" : "Annual Meeting 2020",
	"Agenda" : "Society renovation, Parking issues",
	"minutesOfMeeting" : "none"
}
*/