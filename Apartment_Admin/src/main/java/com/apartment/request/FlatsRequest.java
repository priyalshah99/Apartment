package com.apartment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatsRequest {
	private String flatNo;
    private int bhk;
    private String parkingSlot;

}
/*
  {
  	"flatNo":"A-101",
  	"bhk":2,
  	"parkingSlot":"3A101"
  }
*/
