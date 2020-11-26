package com.apartment.response;

import com.apartment.models.Flats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonpaidMaintainenaceResponse {

    private String flatNumber;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;

    public static NonpaidMaintainenaceResponse build(final Flats flat) {
        NonpaidMaintainenaceResponse response = new NonpaidMaintainenaceResponse();
        response.setFlatNumber(flat.getFlatNo());
        response.setOwnerName(flat.getOwner().getName());
        response.setOwnerEmail(flat.getOwner().getEmail());
        response.setOwnerPhone(flat.getOwner().getContactNo());
        return response;
    }
}