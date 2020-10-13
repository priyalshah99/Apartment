package com.apartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Meetings;

@Repository
public interface MeetingRepo extends JpaRepository<Meetings,Long> {

}
