package Lexicon.Rent_Cars.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.repository.CarsRepo;



@Service
@Transactional
public class Cars_Service_Impl implements  Cars_Service{
	
	private CarsRepo cars_Repo;
	
	@Autowired
	public Cars_Service_Impl(CarsRepo cars_Repo) {
		super();
		this.cars_Repo = cars_Repo;
	}

	@Override
	public Cars findById(int id) {
		Optional<Cars> Result = cars_Repo.findById(id);
		if (Result.isPresent()) {
			return Result.get();
		}
		return null;
	}
	
	@Override
	public Cars save(Cars car) {
		return cars_Repo.save(car);
	}

	@Override
	public boolean remove(int id) {
		 cars_Repo.deleteById(id);
		return cars_Repo.existsById(id);
	}

	@Override
	public List<Cars> findAll() {
		
		return (List<Cars>) cars_Repo.findAll();
	}
}
