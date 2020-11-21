package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Complaints;
import com.apartment.repo.ComplaintsRepo;
import com.apartment.repo.OwnerRepo;
import com.apartment.request.ComplaintsRequest;
import com.apartment.service.ComplaintsService;
import com.apartment.utils.Constants;

@Service
public class ComplaintsServiceImpl implements ComplaintsService{

	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
	
	@Autowired
	private ComplaintsRepo complaintsRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public void saveComplaint(ComplaintsRequest complaintRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		Complaints complaint = new Complaints();
		complaint.setDate(LocalDate.parse(complaintRequest.getDate(),formatter));
		complaint.setDescription(complaintRequest.getDescription());
		complaint.setStatus(complaintRequest.getStatus());
		complaint.setOwner(ownerRepo.getOne(complaintRequest.getOwnerId()));
		
		complaintsRepo.save(complaint);
		
	}

	@Override
	public int upvote(Long id) {
		Complaints complaint = complaintsRepo.getOne(id);
		complaint.setUpVote(complaint.getUpVote()+1);
		complaintsRepo.save(complaint);
		return complaint.getUpVote();
	}

	@Override
	public int downvote(Long id) {
		Complaints complaint = complaintsRepo.getOne(id);
		complaint.setDownVote(complaint.getDownVote()+1);
		complaintsRepo.save(complaint);
		return complaint.getDownVote();
	}

	@Override
	public List<Complaints> fetchAll() {
		return complaintsRepo.findAll();
	}

	@Override
	public Complaints fetch(Long id) {
		return complaintsRepo.getOne(id);
	}

	@Override
	public void saveComplaint(ComplaintsRequest complaintRequest, Long id) {
		Complaints complaint = complaintsRepo.getOne(id);
		complaint.setDate(LocalDate.parse(complaintRequest.getDate(),formatter));
		complaint.setDescription(complaintRequest.getDescription());
		complaint.setStatus(complaintRequest.getStatus());
		complaint.setOwner(ownerRepo.getOne(complaintRequest.getOwnerId()));
		
		complaintsRepo.save(complaint);
		
	}

	@Override
	public void updateComplaintStatus(Long id, int status) {
		Complaints complaint = complaintsRepo.getOne(id);
		complaint.setStatus(status);
		
		complaintsRepo.save(complaint);
		
	}

	@Override
	public void updateComplaintDescription(long id, String description) {
		Complaints complaint = complaintsRepo.getOne(id);
		complaint.setDescription(description);
		
		complaintsRepo.save(complaint);
		
	}
}
