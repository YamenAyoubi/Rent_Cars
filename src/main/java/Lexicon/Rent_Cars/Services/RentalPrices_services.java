package Lexicon.Rent_Cars.Services;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface RentalPrices_services {
	
	RentalPrices Save(RentalPrices rentalPrices);
	
	boolean Remove (int id);

}
