package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Cars;



public interface Cars_Services {
	
	Cars findById(int id);
	
	public List<Cars> findAll();
	
	Cars save(Cars car);
	
	boolean remove(int id);
		
}