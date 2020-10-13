package com.apartment.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Positions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int positionId;
	private String positionName;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    private Owner owner;
	
	@ManyToMany
	@JoinTable(
	  name = "Position_Election", 
	  joinColumns = @JoinColumn(name = "positionId"), 
	  inverseJoinColumns = @JoinColumn(name = "electionId"))
	Set<Election> elections;
}
