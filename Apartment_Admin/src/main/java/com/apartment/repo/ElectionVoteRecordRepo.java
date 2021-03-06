package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.models.ElectionVoteRecord;
import com.apartment.models.Owner;

public interface ElectionVoteRecordRepo extends JpaRepository<ElectionVoteRecord,Long> {
	
	List<ElectionVoteRecord> findByMember(Owner owner);
}
