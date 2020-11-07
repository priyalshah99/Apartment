package com.apartment.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintsRequest {
	private String date;
	private String description;	
	private int status;
	private long ownerId;
}
/*
 {
 	"date":"13/05/2020",
 	"description":"This is test complain",
 	"status":0,
 	"ownerId":1
 }
 */
