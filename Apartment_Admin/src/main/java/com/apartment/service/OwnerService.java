package com.apartment.service;

import java.util.List;

import com.apartment.models.EmployeeDetails;
import com.apartment.models.Flats;
import com.apartment.models.Owner;
import com.apartment.request.OwnerRequest;

public interface OwnerService {
	
	void saveOwner(final OwnerRequest ownerRequest);
	
	void updateOwner(final Long id,final OwnerRequest ownerRequest);
	
	void deleteOwner(final Long id);	
	
	List<Owner> fetchAll();
	
	Owner fetchOwner(final Long id);
	
	Owner setActive(final Long id, final boolean active);
	
	List<Owner> getActiveOwner();
	
	List<Owner> getInactiveOwner();

}
