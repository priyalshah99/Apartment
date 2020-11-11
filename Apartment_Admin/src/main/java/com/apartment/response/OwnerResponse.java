package com.apartment.response;

import java.time.format.DateTimeFormatter;

import com.apartment.models.Owner;
import com.apartment.utils.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponse {
	
	private String name;
	private String contactNo;
	private String email;
	private String dateOfPurchase;
	
	public OwnerResponse(String name, String contactNo, String email, String dateOfPurchase) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.dateOfPurchase = dateOfPurchase;
	}

	public static OwnerResponse build(final Owner owner) {
		return new OwnerResponse(owner.getName(), owner.getContactNo(), owner.getEmail(), owner.getDateOfPurchase().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
	}
	
	
	
	
}