package Lexicon.Rent_Cars.Services;
import java.util.List;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface RentalPrices_services {
	
	RentalPrices Save(RentalPrices rentalPrices);
	
	boolean Remove (int id);
	
	void AddRentPricesToCars (RentalPrices rentalPrices);
	
	
}
