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
public class Flats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flatId;
	private String flatNo;
    private boolean occupied;
    private int bhk;
    private String parkingSlot;
    
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Owner owner;

    
    

}
