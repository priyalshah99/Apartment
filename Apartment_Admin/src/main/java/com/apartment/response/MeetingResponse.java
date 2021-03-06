package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Meetings;
import com.apartment.utils.Constants;

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
	private boolean active;
	
	public static MeetingResponse build(final Meetings meeting) {
		MeetingResponse response = new MeetingResponse();
		response.setMeetingId(meeting.getMeetingId());
		response.setTopic(meeting.getTopic());
		response.setAgenda(meeting.getAgenda());
		response.setMinutesOfMeeting(meeting.getMinutesOfMeeting());
		response.setStartTime(meeting.getStartTime().toLocalDateTime().format(DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT)));
		response.setEndTime(meeting.getEndTime().toLocalDateTime().format(DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT)));
		response.setActive(meeting.isActive());
		return response;
	}
}