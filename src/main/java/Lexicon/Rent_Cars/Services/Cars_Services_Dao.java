package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface Cars_Services_Dao {

	Cars findById_Car(int id);

	Cars save_Car(Cars car);

	boolean remove_Car(int id);

	List<Cars> findAll_Cars();

	boolean AddCarToAgreement(int agreement_id, int car_id);

	boolean AddCarToBranch(int car_id, int branch_id);

	List<Cars> findByNameIgnoreCase_car(String name);

	List<Cars> FindUnRentedCars();

	List<Cars> FindRentedCars();

	Cars Add_Rentalprice_ToCar(int rentalPrices_id, int car_id);

	Cars Add_MoreDescriptions_ToCar(int moreDescriptions_id, int id);

	List<Cars> findByRentalprices(int rentalprices);

	MoreDescriptions Save_More_Des(MoreDescriptions MoreDes);

	boolean Remove_More_Des(int id);

	RentalPrices Save_Rent_Price(RentalPrices rentalPrices);

	boolean Remove_Rent_Price(int id);

	RentalPrices findById_rentalPrice(int id);

	List<RentalPrices> findAll_rentalPrice();

	MoreDescriptions findById_moreDes(int id);

	List<MoreDescriptions> findAll__moreDes();

	void agreement_finished_CarBoolean(int agreement_id);
}