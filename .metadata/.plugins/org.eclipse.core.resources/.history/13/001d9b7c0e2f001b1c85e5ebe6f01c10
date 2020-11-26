package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Flats;

@Repository
public interface FlatsRepo extends JpaRepository <Flats,Integer> {

	List<Flats> findByOccupiedTrue();
	List<Flats> findByOccupiedFalse();
	Flats findFirstByFlatNo(final String flatNo);

}
