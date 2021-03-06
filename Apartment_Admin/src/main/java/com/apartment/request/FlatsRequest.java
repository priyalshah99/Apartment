package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatsRequest {
	private String flatNo;
    private int bhk;
    private String parkingSlot;
    private boolean occupied;
    private long ownerId;

}
/*
  {
  	"flatNo":"A-101",
  	"bhk":2,
  	"parkingSlot":"3A101"
  	
  	
  }
*/
/*
 * "occupied":"1", "ownerId":"1"
 */