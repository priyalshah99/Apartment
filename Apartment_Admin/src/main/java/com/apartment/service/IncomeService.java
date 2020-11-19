package com.apartment.service;

import java.util.List;

import com.apartment.exception.RecordAlreadyExistException;
import com.apartment.models.Income;
import com.apartment.request.IncomeRequest;

public interface IncomeService {
	
	void saveIncome(final IncomeRequest incomeRequest) throws RecordAlreadyExistException;
	
	void saveIncome(final Long id, final IncomeRequest incomeRequest);
	
	void deleteIncome(final Long id);
	
	Income fetch(final Long id);
	
	List<Income> fetchAll();
	
	List<Income> filter(final String startDate, final String endDate);

}
