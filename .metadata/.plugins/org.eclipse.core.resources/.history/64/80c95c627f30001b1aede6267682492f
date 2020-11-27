package com.apartment.service;

import java.util.List;

import com.apartment.models.Meetings;
import com.apartment.request.MeetingRequest;

public interface MeetingService {

	void addMeeting(final MeetingRequest meetingRequest);
	
	void updateMeeting(final Long id, final MeetingRequest meetingRequest);
	
	void deleteMeeting(final Long id);
	
	List<Meetings> fetchMeetings(final String state);
	
	Meetings fetchMeeting(final Long id);
}
