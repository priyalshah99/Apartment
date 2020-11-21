package com.apartment.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ElectionResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long electionResultId;
	private int voteCount;
	private boolean winner;
	
	@ManyToOne
    @JoinColumn(name = "ownerId")
    private Owner owner;
	
	@ManyToOne
    @JoinColumn(name = "positionId")
    private ElectionPosition electionPosition;
	
	@ManyToOne
    @JoinColumn(name = "electionId")
    private Election election;
}