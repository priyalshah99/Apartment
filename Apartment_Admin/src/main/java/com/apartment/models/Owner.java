package com.apartment.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ownerId;
	private String name;
	private String contactNo;
	private String email;
	private LocalDate dateOfPurchase;
	private boolean active;
	private String password;
	
	@ManyToMany(mappedBy = "owners")
    private Set<ElectionResult> electionResult = new HashSet<>();
	
}
