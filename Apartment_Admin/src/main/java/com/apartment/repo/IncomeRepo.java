package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.Income;

@Repository
public interface IncomeRepo extends JpaRepository <Income,Integer> {

}
