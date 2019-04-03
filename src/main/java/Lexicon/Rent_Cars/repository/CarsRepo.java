package Lexicon.Rent_Cars.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import Lexicon.Rent_Cars.entity.Cars;

public interface CarsRepo extends CrudRepository<Cars, Integer> {

	List<Cars> findByNameIgnoreCase(String name);

}
