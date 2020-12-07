package com.apartment.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Already_Voted", 
        joinColumns = { @JoinColumn(name = "electionResultId") }, 
        inverseJoinColumns = { @JoinColumn(name = "ownerId") }
    )
    Set<Owner> owners = new HashSet<>();
}











