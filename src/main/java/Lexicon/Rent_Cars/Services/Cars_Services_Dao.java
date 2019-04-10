package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface Cars_Services_Dao {

	Cars findById_Car(int id);

	Cars save_Car(Cars car);

	boolean remove_Car(int id);

	List<Cars> findAll_Cars();

	boolean AddCarToAgreement(Agreement agreement ,Cars car);

	boolean AddCarToBranch(Cars car,Branches branch);

	List<Cars> findByNameIgnoreCase(String name);

	List<Cars> FindUnRentedCars(Cars car);

	List<Cars> FindRentedCars(Cars car);

	Cars Add_Rentalprice_ToCar(RentalPrices rentalPrices,int id);

	Cars Add_MoreDescriptions_ToCar(MoreDescriptions moreDescriptions,int id);

	List<Cars> findByRentalprices(int rentalprices);

	MoreDescriptions Save_More_Des(MoreDescriptions MoreDes);

	boolean Remove_More_Des(int id);

	RentalPrices Save_Rent_Price(RentalPrices rentalPrices);

	boolean Remove_Rent_Price(int id);



}