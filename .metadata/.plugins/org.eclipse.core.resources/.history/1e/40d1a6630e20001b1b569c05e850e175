package com.apartment.models;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Complaints {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long complaintId;	
	private Date date;	
	private String description;	
	private int upVote;	
	private int downVote;	
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Owner owner;
	
}
