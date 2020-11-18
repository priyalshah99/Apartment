package com.apartment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.apartment.exception.RecordAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.models.Income;
import com.apartment.repo.IncomeRepo;
import com.apartment.request.IncomeRequest;
import com.apartment.service.IncomeService;
import com.apartment.utils.Constants;

@Service
public class IncomeServiceImpl implements IncomeService {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

	@Autowired
	private IncomeRepo incomeRepo;

	@Override
	public void saveIncome(IncomeRequest incomeRequest) {
		if(!incomeRepo.findByDate(LocalDate.parse(incomeRequest.getDate(),formatter)).isEmpty()) {
		//	throw new RecordAlreadyExistException("Income record exists for date "+incomeRequest.getDate());
		}
		Income income = new Income();
		income.setAmount(incomeRequest.getAmount());
		income.setContactNo(incomeRequest.getContactNo());
		income.setName(incomeRequest.getName());
		income.setReason(incomeRequest.getReason());
		income.setDate(LocalDate.parse(incomeRequest.getDate(),formatter));
		
		incomeRepo.save(income);
		
	}

	@Override
	public void saveIncome(Long id, IncomeRequest incomeRequest) {
		Income income = incomeRepo.getOne(id);
		income.setAmount(incomeRequest.getAmount());
		income.setContactNo(incomeRequest.getContactNo());
		income.setName(incomeRequest.getName());
		income.setReason(incomeRequest.getReason());
		income.setDate(LocalDate.parse(incomeRequest.getDate(),formatter));
		
		incomeRepo.save(income);
		
	}

	@Override
	public void deleteIncome(Long id) {
		incomeRepo.deleteById(id);
		
	}

	@Override
	public Income fetch(Long id) {
		return incomeRepo.getOne(id);
	}

	@Override
	public List<Income> fetchAll() {
		return incomeRepo.findAll();
	}

	@Override
	public List<Income> filter(String startDate, String endDate) {
		return incomeRepo.findByDateBetween(LocalDate.parse(startDate,formatter), LocalDate.parse(endDate,formatter));
	}
	
}
