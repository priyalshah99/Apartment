package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Complaints;

@Repository
public interface ComplaintsRepo extends JpaRepository <Complaints,Long>{

}
