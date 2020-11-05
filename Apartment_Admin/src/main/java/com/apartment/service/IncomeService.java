package com.apartment.service;

import java.util.List;

import com.apartment.models.Income;
import com.apartment.request.IncomeRequest;
import com.apartment.response.IncomeResponse;

public interface IncomeService {
	
	void saveIncome(final IncomeRequest incomeRequest);
	
	void saveIncome(final Long id, final IncomeRequest incomeRequest);
	
	void deleteIncome(final Long id);
	
	Income fetch(final Long id);
	
	List<Income> fetchAll();
	
	List<Income> filter(final String startDate, final String endDate);

}
