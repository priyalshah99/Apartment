package com.apartment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.request.ComplaintsDescriptionRequest;
import com.apartment.request.ComplaintsRequest;
import com.apartment.request.ComplaintsStatusRequest;
import com.apartment.response.ComplaintResponse;
import com.apartment.service.ComplaintsService;

@RestController
@RequestMapping("/complaints")
@CrossOrigin(origins="http://localhost:4200")
public class ComplaintsController {

	@Autowired
	private ComplaintsService complaintsService;
	
	@PostMapping("/")
	public String addComplaints(@RequestBody final ComplaintsRequest complaintRequest) {
		complaintsService.saveComplaint(complaintRequest);
		return "Complaints added successfully";
	}
	
	@PutMapping("/{id}/status")
	public String updateStatus(@PathVariable final long id,@RequestBody final ComplaintsStatusRequest status) {
		complaintsService.updateComplaintStatus(id, status.getStatus());
		return "Complaint status updated successfully";
	}
	
	@PutMapping("/{id}/description")
	public String updateDescription(@PathVariable final long id,@RequestBody final ComplaintsDescriptionRequest description) {
		complaintsService.updateComplaintDescription(id, description.getDescription());
		return "Complaint status updated successfully";
	}
	
	@PutMapping("/{id}")
	public String updateComplaints(@RequestBody final ComplaintsRequest complaintRequest, @PathVariable final long id) {
		complaintsService.saveComplaint(complaintRequest, id);
		return "Complaints updated successfully";
	}
	
	@PutMapping("/{id}/upvote/")
	public int upvote(@PathVariable final long id) {
		return complaintsService.upvote(id);
	}
	
	@PutMapping("/{id}/downvote/")
	public int downvote(@PathVariable final long id) {
		return complaintsService.downvote(id);
	}
	
	@GetMapping("/")
	public List<ComplaintResponse> fetchComplaints() {
		return complaintsService.fetchAll()
				.stream()
				.map(com -> ComplaintResponse.build(com))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ComplaintResponse fetchComplaint(@PathVariable final long id) {
		return ComplaintResponse.build(complaintsService.fetch(id));
	}
}
