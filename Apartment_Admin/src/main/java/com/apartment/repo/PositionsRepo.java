package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Election;
import com.apartment.models.Positions;

@Repository
public interface PositionsRepo extends JpaRepository <Positions,Integer> {

}
