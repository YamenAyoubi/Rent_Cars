package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Agreement;


public interface Agreement_Services {

	
	Agreement findById(int id);
	
	public List<Agreement> findAll();
	
	Agreement save(Agreement agreement);
	
	boolean remove(int id);
	
}
