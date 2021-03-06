package com.apartment.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Maintenance {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long maintenanceId;
		private double amount;
		private LocalDate date;
		private int month;
		private String paymentMode;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "flatId", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private Flats flat;
}
