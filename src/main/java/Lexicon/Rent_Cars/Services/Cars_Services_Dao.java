package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface Cars_Services_Dao {

	Cars findById(int id);

	Cars save(Cars car);

	boolean remove(int id);

	List<Cars> findAll();

	boolean AddCarToAgreement(Cars car);

	boolean AddCarToBranch(Cars car);

	List<Cars> findByNameIgnoreCase(String name);

	List<Cars> FindUnRentedCars(Cars car);

	List<Cars> FindRentedCars(Cars car);

	Cars AddPricesToCar(RentalPrices rentalPrices);

	Cars AddDesToCar(MoreDescriptions moreDescriptions);

	List<Cars> findByRentalprices(int rentalprices);

	MoreDescriptions Save_More_Des(MoreDescriptions MoreDes);

	boolean Remove_More_Des(int id);

	void AddMoreInfoToCars(MoreDescriptions MoreDes);

	RentalPrices Save_Rent_Price(RentalPrices rentalPrices);

	boolean Remove_Rent_Price(int id);

	void AddRentPricesToCars(RentalPrices rentalPrices);

}