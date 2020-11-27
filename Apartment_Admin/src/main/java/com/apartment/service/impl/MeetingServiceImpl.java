 package com.apartment.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Meetings;
import com.apartment.models.Owner;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
		Meetings meeting = new Meetings();
		meeting.setAgenda(meetingRequest.getAgenda());
		meeting.setTopic(meetingRequest.getTopic());
		meeting.setStartTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getStartTime(),formatter)));
		meeting.setEndTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getEndTime(),formatter)));
		meeting.setMinutesOfMeeting(meetingRequest.getMinutesOfMeeting());
		meeting.setActive(meetingRequest.isActive());
		
		meetingRepo.save(meeting);
	}

	@Override
	public List<Meetings> fetchMeetings(final String state) {
		if(state.equalsIgnoreCase(Constants.UPCOMING)) {
			return meetingRepo.findByStartTimeAfter(Timestamp.valueOf(LocalDateTime.now()));
		} else if(state.equalsIgnoreCase(Constants.COMPLETED)) {
			return meetingRepo.findByEndTimeBefore(Timestamp.valueOf(LocalDateTime.now()));
		}
		return meetingRepo.findAll();
	}

	@Override
	public Meetings fetchMeeting(Long id) {
		return meetingRepo.getOne(id);
	}

	@Override
	public void updateMeeting(Long id, MeetingRequest meetingRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
		Meetings meeting = meetingRepo.getOne(id);
		meeting.setAgenda(meetingRequest.getAgenda());
		meeting.setTopic(meetingRequest.getTopic());
		meeting.setStartTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getStartTime(),formatter)));
		meeting.setEndTime(Timestamp.valueOf(LocalDateTime.parse(meetingRequest.getEndTime(),formatter)));
		meeting.setMinutesOfMeeting(meetingRequest.getMinutesOfMeeting());
		meeting.setActive(meetingRequest.isActive());
		
		meetingRepo.save(meeting);
		
	}
	
	@Override
	public Meetings setActive(Long id, boolean active) {
		Meetings meet = meetingRepo.getOne(id);
		meet.setActive(active);
		meetingRepo.save(meet);
		return meet;
	}

	@Override
	public void deleteMeeting(Long id) {
		meetingRepo.deleteById(id);
	}
}
