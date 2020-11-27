package com.apartment.repo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.Meetings;

@Repository
public interface ElectionRepo extends JpaRepository <Election,Long> {

	List<Election> findByEndDateBefore(LocalDate date);
    List<Election> findByDateAfter(LocalDate date);
}
