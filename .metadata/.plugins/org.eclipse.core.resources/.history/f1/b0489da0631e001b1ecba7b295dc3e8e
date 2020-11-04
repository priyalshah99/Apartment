package com.apartment.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int electionId;
	private int voteCount;
	private Date date;
	private boolean result;
	
	@ManyToMany(mappedBy = "elections")
	Set<Positions> positions;
	
	@ManyToMany
	@JoinTable(
	  name = "Owner_Election", 
	  joinColumns = @JoinColumn(name = "electionId"), 
	  inverseJoinColumns = @JoinColumn(name = "ownerId"))
	Set<Owner> owner;
	
}
