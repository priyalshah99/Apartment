package com.apartment.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Flats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flatId;
	private String flatNo;
    private boolean occupied;
    private int bhk;
    private String parkingSlot;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ownerId", nullable = true)
    private Owner owner;


}
