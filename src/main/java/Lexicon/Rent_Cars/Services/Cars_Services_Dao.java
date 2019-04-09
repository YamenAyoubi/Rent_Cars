package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;



public interface Cars_Services_Dao {
	
	Cars findById(int id);
	
	List<Cars> findAll();
	
	Cars save(Cars car);
	
	boolean remove(int id);
	
	boolean AddCarToAgreement (Cars car);
	
	boolean AddCarToBranch (Cars car);
	
	List<Cars> FindRentedCars (Cars car);
	
	List<Cars> FindUnRentedCars (Cars car);
	
	List<Cars> findByNameIgnoreCase(String name);

	Cars AddPricesToCar(RentalPrices rentalPrices);

	Cars AddDesToCar(MoreDescriptions moreDescriptions);
	
	List<Cars> findByRentalprices(int rentalprices);
}
