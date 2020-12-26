package com.apartment.service;

import java.util.List;

import com.apartment.models.Funds;
import com.apartment.request.FundsRequest;

public interface FundsService {

	void saveFunds(final FundsRequest fundsRequest);
	
	void updateFunds(final Long id, final FundsRequest fundsRequest);
	
	List<Funds> getAll();
	
	Funds getFunds(final Long id);
	
	void deleteFunds(final Long id);
	
	List<Funds> getByOwner(final Long id);
}
