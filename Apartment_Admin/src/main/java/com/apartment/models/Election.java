package com.apartment.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long electionId;
	private LocalDate date;
	private String electionName;
	private boolean active;
	private LocalDate endDate;
	
//	private boolean winner;
//	private int voteCount;
	/*
	 * @ManyToMany(mappedBy = "elections") Set<Positions> positions;
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "Owner_Election", joinColumns = @JoinColumn(name =
	 * "electionId"), inverseJoinColumns = @JoinColumn(name = "ownerId")) Set<Owner>
	 * owner;
	 */
}
