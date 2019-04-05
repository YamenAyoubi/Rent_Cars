package Lexicon.Rent_Cars.Services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.RentalPrices;
import Lexicon.Rent_Cars.repository.CarsRepo;
import Lexicon.Rent_Cars.repository.RentalPricesRepo;

@Service
@Transactional
public class RentalPrices_services_Impl implements RentalPrices_services{

	
	private RentalPricesRepo rentalPrices_repo;
	private CarsRepo cars_Repo;
	private Cars car;

	@Autowired
	public RentalPrices_services_Impl(RentalPricesRepo rentalPrices_repo) {
		super();
		this.rentalPrices_repo = rentalPrices_repo;
	}

	@Override
	public RentalPrices Save(RentalPrices rentalPrices) {
		
		return rentalPrices_repo.save(rentalPrices);
	}

	@Override
	public boolean Remove(int id) {
		rentalPrices_repo.deleteById(id);
		return rentalPrices_repo.existsById(id);
	}
	
	public void AddRentPricesToCars (RentalPrices rentalPrices) {
		car.setRentalprices(rentalPrices);
		cars_Repo.save(car);
	}


}
