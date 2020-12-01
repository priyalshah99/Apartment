package com.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.models.Meetings;
import com.apartment.request.MeetingRequest;
import com.apartment.response.ElectionResponse;
import com.apartment.response.MeetingResponse;
import com.apartment.service.MeetingService;

@RestController
@RequestMapping("/meeting")
@CrossOrigin(origins="http://localhost:4200")
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
	
	@PutMapping("/{id}")
	public String updateMeeting(@PathVariable final Long id,@RequestBody MeetingRequest request) {
		meetingService.updateMeeting(id, request);
		return "Meeting updated successfully";
	}
	
	@PutMapping("/{id}/active")
	public MeetingResponse activeMeeting(@PathVariable final long id) {
		return MeetingResponse.build(meetingService.setActive(id, true));
		
	}
	
	@PutMapping("/{id}/inactive")
	public MeetingResponse inactiveMeeting(@PathVariable final long id) {
		return MeetingResponse.build(meetingService.setActive(id, false));

	}	
	
	@DeleteMapping("/{id}")
	public String deleteMeeting(@PathVariable final Long id) {
		meetingService.deleteMeeting(id);
		return "Meeting deleted successfully";
	}
	
	@GetMapping("/{state}")
	public List<Meetings> getMeetings(@PathVariable final String state) {
		return meetingService.fetchMeetings(state);
	}
	
	@GetMapping("/fetch/{id}")
	public MeetingResponse getMeeting(@PathVariable final Long id) {
		return MeetingResponse.build(meetingService.fetchMeeting(id));
	}
	
	

}
