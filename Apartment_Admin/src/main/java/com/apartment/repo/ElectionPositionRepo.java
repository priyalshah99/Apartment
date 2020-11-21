package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.ElectionPosition;

@Repository
public interface ElectionPositionRepo extends JpaRepository <ElectionPosition,Integer> {

}
