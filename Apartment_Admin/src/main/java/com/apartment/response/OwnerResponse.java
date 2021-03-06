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
	private boolean active;
	private String password;
	private Long id;
	
	public OwnerResponse(Long id,String name, String contactNo, String email, String dateOfPurchase, boolean active,String password) {
		super();
		this.id=id;
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.dateOfPurchase = dateOfPurchase;
		this.active=active;
		this.password=password;
	}

	public static OwnerResponse build(final Owner owner) {
		return new OwnerResponse(owner.getOwnerId(),owner.getName(), owner.getContactNo(), owner.getEmail(), owner.getDateOfPurchase()==null?null:owner.getDateOfPurchase().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)),owner.isActive(),owner.getPassword());
	}
	
	
	
	
}
