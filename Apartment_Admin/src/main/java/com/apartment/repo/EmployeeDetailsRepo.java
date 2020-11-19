package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository <EmployeeDetails,Long> {

}
