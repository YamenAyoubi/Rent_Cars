package Lexicon.Rent_Cars.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.RentalPrices;

public interface RentalPricesRepo extends CrudRepository<RentalPrices, Integer> {

	
}
