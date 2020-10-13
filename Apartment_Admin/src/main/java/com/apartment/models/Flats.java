package com.apartment.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Id;

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
    @JoinColumn(name = "ownerId", nullable = false)
    private Owner owner;


}
