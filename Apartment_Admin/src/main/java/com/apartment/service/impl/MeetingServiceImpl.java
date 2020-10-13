package com.apartment.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Meetings;
import com.apartment.repo.MeetingRepo;
import com.apartment.request.MeetingRequest;
import com.apartment.service.MeetingService;
import com.apartment.utils.Constants;

@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	private MeetingRepo meetingRepo;

	@Override
	public void addMeeting(MeetingRequest meetingRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Meetings meeting = new Meetings();
		meeting.setAgenda(meetingRequest.getAgenda());
		meeting.setTopic(meetingRequest.getTopic());
		meeting.setStartTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getStartTime(),formatter)));
		meeting.setEndTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getEndTime(),formatter)));
		meeting.setMinutesOfMeeting(meetingRequest.getMinutesOfMeeting());
		
		meetingRepo.save(meeting);
	}

}
