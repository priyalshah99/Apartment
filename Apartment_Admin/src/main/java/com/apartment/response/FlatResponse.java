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
    private boolean occupied;
    private Long ownerId;
    private int flatId;
   
    
    public FlatResponse(final int flatId,final String flatNo, final int bhk, final String parkingSlot, final String ownerName, final boolean occupied,final Long ownerId) {
    	this.flatNo = flatNo;
    	this.bhk = bhk;
    	this.parkingSlot = parkingSlot;
    	this.ownerName = ownerName;
    	this.occupied=occupied;
    	this.ownerId=ownerId;
    	this.flatId=flatId;
    }
    
    public static FlatResponse build(final Flats flat) {
    	return new FlatResponse(flat.getFlatId(),flat.getFlatNo(),flat.getBhk(),flat.getParkingSlot(),flat.getOwner().getName(),flat.isOccupied(),flat.getOwner().getOwnerId()==0?null:flat.getOwner().getOwnerId());
    }
}
