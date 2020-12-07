package com.apartment.models;

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
