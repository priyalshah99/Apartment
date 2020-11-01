package com.apartment.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.models.Meetings;

@Repository
public interface MeetingRepo extends JpaRepository<Meetings,Long> {
	List<Meetings> findByEndTimeBefore(Timestamp time);
    List<Meetings> findByStartTimeAfter(Timestamp time);
}
