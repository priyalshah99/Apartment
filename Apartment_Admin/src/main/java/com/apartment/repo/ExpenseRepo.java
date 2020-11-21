package com.apartment.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Expense;
import com.apartment.models.Income;

@Repository
public interface ExpenseRepo extends JpaRepository <Expense,Long>{
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);


}
