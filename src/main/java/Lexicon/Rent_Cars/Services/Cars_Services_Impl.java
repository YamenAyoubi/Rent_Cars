package Lexicon.Rent_Cars.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.CarsRepo;



@Service
@Transactional
public class Cars_Services_Impl implements  Cars_Services{
	
	private CarsRepo cars_Repo;
	private AgreementRepo agreement_Repo;
	private Agreement agreement;
	private Branches branch;
	
	@Autowired
	public Cars_Services_Impl(CarsRepo cars_Repo) {
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
	
	public boolean AddCarToAgreement (Cars car) {
		if (!car.getMore_Descriptions().isRented()==true) {
			agreement.setSelected_Car(car);
			agreement_Repo.save(agreement);
		}else {
			System.out.println("Unable to Add The Car Already Rented");
		}
		return car.getMore_Descriptions().isRented();	
	}
	
	public boolean AddCarToBranch (Cars car) {
		
		List<Cars> BranchCars = new ArrayList<>();
		branch.setBranchCars(BranchCars);
		return BranchCars.add(car);	
	}	
	
	public List<Cars> findByNameIgnoreCase(String name){
		
		return cars_Repo.findByNameIgnoreCase(name);
	}
}
