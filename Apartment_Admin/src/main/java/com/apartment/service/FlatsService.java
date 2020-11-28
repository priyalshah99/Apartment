package com.apartment.service;

import java.util.List;

import com.apartment.models.Flats;
import com.apartment.request.FlatsRequest;

public interface FlatsService {
	
	void saveFlat(final FlatsRequest flatRequest);
	
	void updateFlat(final int id, final FlatsRequest flatRequest);
	
	Flats setOccupied(final int id, final boolean occupied);
	
	List<Flats> getEmptyFlats();
	
	List<Flats> getOccupiedFlats();
	
	List<Flats> getAllFlats();
	
	Flats getFlats(final int id);

	void deleteFlats(int id);
	
	List<Flats> getAllByOwner(Long id);
}
