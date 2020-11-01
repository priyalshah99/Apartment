package com.apartment.service;

import java.util.List;

import com.apartment.models.Complaints;
import com.apartment.request.ComplaintsRequest;

public interface ComplaintsService {

	public void saveComplaint(final ComplaintsRequest complaintRequest);
	
	public void saveComplaint(final ComplaintsRequest complaintRequest, final Long id);
	
	public int upvote(Long id);
	
	public int downvote(Long id);
	
	public List<Complaints> fetchAll();
	
	public Complaints fetch(final Long id);
}
