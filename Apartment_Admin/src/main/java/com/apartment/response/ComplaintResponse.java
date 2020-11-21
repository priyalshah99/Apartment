package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Complaints;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintResponse {
	private Long id;
	private String date;	
	private String description;	
	private int upVote;	
	private int downVote;	
	private int status;
	private String submitter;
	private Long ownerId;
	
	public static ComplaintResponse build(final Complaints complaint) {
		ComplaintResponse complaintResponse = new ComplaintResponse();
		complaintResponse.setId(complaint.getComplaintId());
		complaintResponse.setDate(complaint.getDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		complaintResponse.setDescription(complaint.getDescription());
		complaintResponse.setUpVote(complaint.getUpVote());
		complaintResponse.setDownVote(complaint.getDownVote());
		complaintResponse.setStatus(complaint.getStatus());
		complaintResponse.setSubmitter(complaint.getOwner().getName());
		complaintResponse.setOwnerId(complaint.getOwner().getOwnerId());
		return complaintResponse;
	}

}
