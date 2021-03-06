package com.apartment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apartment.models.Flats;
import com.apartment.models.Maintenance;

@Repository
public interface MaintenanceRepo extends JpaRepository <Maintenance,Long> {

	@Query("select flat from Flats flat where flat.occupied = true and flat.flatId not in (select mnt.flat.flatId from Maintenance mnt where mnt.month = ?1)")
	List<Flats> findFlatsWithNoMaintenancePaid(final int month);
	
	List<Maintenance> findByFlat(Flats f);
}
