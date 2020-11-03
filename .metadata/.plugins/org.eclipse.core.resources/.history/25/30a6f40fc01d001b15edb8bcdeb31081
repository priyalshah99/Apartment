package com.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.models.Meetings;
import com.apartment.request.MeetingRequest;
import com.apartment.service.MeetingService;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	@PostMapping("/")
	public String addMeeting(@RequestBody MeetingRequest request) {
		try {
			
			meetingService.addMeeting(request);
			return "Meeting created successfully";
		} catch (Exception e) {
			return "Error occurred while creating meeting, because of,"+e.getMessage();
		}
	}
	
	@GetMapping("/{state}")
	public List<Meetings> getMeetings(@PathVariable final String state) {
		return meetingService.fetchMeetings(state);
	}
	
	@GetMapping("/fetch/{id}")
	public Meetings getMeeting(@PathVariable final Long id) {
		return meetingService.fetchMeeting(id);
	}
	
	

}
