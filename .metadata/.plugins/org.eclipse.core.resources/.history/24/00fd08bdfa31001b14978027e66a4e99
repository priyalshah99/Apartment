package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Owner;

@Repository
public interface OwnerRepo extends JpaRepository <Owner,Long> {

	List<Owner> findByActiveFalse();

	List<Owner> findByActiveTrue();

	Owner findFirstByEmail(String email);
	
	

}
