package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Funds;

@Repository
public interface FundsRepo extends JpaRepository <Funds,Long> {

}
