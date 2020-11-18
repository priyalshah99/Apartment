package com.apartment.repo;

import com.apartment.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.Expense;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository <Expense,Long>{
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);


}
