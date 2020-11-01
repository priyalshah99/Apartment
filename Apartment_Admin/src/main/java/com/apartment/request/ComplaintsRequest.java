package com.apartment.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintsRequest {
	private Date date;	
	private String description;	
	private int status;
	private long ownerId;
}
/*
 {
 	"date":"",
 	"description":"This is complain",
 	"status":1,
 	"ownerId":1
 }
 */
