package com.apartment.response;

import java.util.Date;

import com.apartment.models.Complaints;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintResponse {
	private Long id;
	private Date date;	
	private String description;	
	private int upVote;	
	private int downVote;	
	private int status;
	private String submitter;
	
	public static ComplaintResponse build(final Complaints complaint) {
		ComplaintResponse complaintResponse = new ComplaintResponse();
		complaintResponse.setId(complaint.getComplaintId());
		complaintResponse.setDate(complaint.getDate());
		complaintResponse.setDescription(complaint.getDescription());
		complaintResponse.setUpVote(complaint.getUpVote());
		complaintResponse.setDownVote(complaint.getDownVote());
		complaintResponse.setStatus(complaint.getStatus());
		complaintResponse.setSubmitter(complaint.getOwner().getName());
		return complaintResponse;
	}

}
