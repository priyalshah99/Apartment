package com.apartment.response;

import com.apartment.models.Flats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatResponse {
	private String flatNo;
    private int bhk;
    private String parkingSlot;
    private String ownerName;
    
    public FlatResponse(final String flatNo, final int bhk, final String parkingSlot, final String ownerName) {
    	this.flatNo = flatNo;
    	this.bhk = bhk;
    	this.parkingSlot = parkingSlot;
    	this.ownerName = ownerName;
    }
    
    public static FlatResponse build(final Flats flat) {
    	return new FlatResponse(flat.getFlatNo(),flat.getBhk(),flat.getParkingSlot(),flat.getOwner().getName());
    }
}