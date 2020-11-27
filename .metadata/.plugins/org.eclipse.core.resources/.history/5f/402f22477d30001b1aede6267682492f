package com.apartment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ElectionPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long positionId;
	private String positionName;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "ownerId", nullable = false) private Owner owner;
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "Position_Election", joinColumns = @JoinColumn(name =
	 * "positionId"), inverseJoinColumns = @JoinColumn(name = "electionId"))
	 * Set<Election> elections;
	 */
}
