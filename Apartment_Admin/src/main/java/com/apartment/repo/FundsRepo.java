package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Funds;
import com.apartment.models.Owner;

@Repository
public interface FundsRepo extends JpaRepository <Funds,Long> {

	List<Funds> findByOwner(Owner owner);

	
}
