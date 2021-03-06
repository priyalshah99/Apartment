package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.ElectionResult;

@Repository
public interface ElectionResultRepo extends JpaRepository <ElectionResult,Long>  {

	List<ElectionResult> findByElection(Election e);
}
