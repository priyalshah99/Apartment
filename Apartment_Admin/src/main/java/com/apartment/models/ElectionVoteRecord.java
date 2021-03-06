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
public class ElectionVoteRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long voteId;
	
	@ManyToOne
    @JoinColumn(name = "ownerId")
	private Owner member;
	
	@ManyToOne
    @JoinColumn(name = "electionResultId")
	private ElectionResult election;
}
