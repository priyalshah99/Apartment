package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.ElectionResult;

@Repository
public interface ElectionResultRepo extends JpaRepository <ElectionResult,Long>  {

}