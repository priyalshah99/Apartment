package com.apartment.response;

import com.apartment.models.Meetings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingResponse {
	private Long meetingId;
	private String startTime;
	private String endTime;
	private String topic;
	private String agenda;
	private String minutesOfMeeting;
	
	public static MeetingResponse build(final Meetings meeting) {
		MeetingResponse response = new MeetingResponse();
		response.setMeetingId(meeting.getMeetingId());
		response.setTopic(meeting.getTopic());
		response.setAgenda(meeting.getAgenda());
		response.setMinutesOfMeeting(meeting.getMinutesOfMeeting());
		return response;
	}
}
