package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.models.ElectionResult;
import com.apartment.models.ElectionVoteRecord;
import com.apartment.models.Owner;

public interface ElectionVoteRecordRepo extends JpaRepository<ElectionVoteRecord,Long> {
	ElectionVoteRecord findFirstByMemberAndElection(Owner owner, ElectionResult election);
}
