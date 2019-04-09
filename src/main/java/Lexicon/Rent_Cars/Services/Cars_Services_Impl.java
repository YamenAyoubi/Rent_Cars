package Lexicon.Rent_Cars.Services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.CarsRepo;



@Service
@Transactional
public class Cars_Services_Impl implements  Cars_Services_Dao{
	
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
		return cars_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
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
	
	@Override
	public boolean AddCarToAgreement (Cars car) {
		if (!car.getMore_Descriptions().isRented()==true) {
			agreement.setSelected_Car(car);
			agreement.getSelected_Car().getMore_Descriptions().setFuel(true);
			agreement_Repo.save(agreement);
		}else {
			System.out.println("Unable to Add The Car Already Rented");
		}
		return car.getMore_Descriptions().isRented()==true;	
	}
	
	@Override
	public boolean AddCarToBranch (Cars car) {
		
		List<Cars> BranchCars = new ArrayList<>();
		branch.setCars_Lists(BranchCars);
		return BranchCars.add(car);	
	}	
	
	@Override
	public List<Cars> findByNameIgnoreCase(String name){
		
		return cars_Repo.findByNameIgnoreCase(name);
	}
	
	@Override
	public List<Cars> FindUnRentedCars (Cars car){
		
		List<Cars> Result=new ArrayList<>();
		
		Result.forEach(x->{
			if (x.getMore_Descriptions().isRented()==false) {
				System.out.println(x.getName());
			}
		});
		return Result;		
	}
	
	@Override
	public List<Cars> FindRentedCars (Cars car){
		
		List<Cars> Result=new ArrayList<>();
		
		Result.forEach(x->{
			if (x.getMore_Descriptions().isRented()==true) {
				System.out.println(x.getName());
			}
		});
		return Result;		
	}
	@Override
	public Cars AddPricesToCar(RentalPrices rentalPrices) {
		Cars car = new Cars();
		car.setRentalprices(rentalPrices);
		return save(car);
	}
	
	@Override
	public Cars AddDesToCar(MoreDescriptions moreDescriptions) {
		Cars car = new Cars();
		car.setMore_Descriptions(moreDescriptions);
		return save(car);	
	}
	
	@Override
	public List<Cars> findByRentalprices(int rentalprices) {
		
		List<Cars> Result=new ArrayList<>();
		
		Result.forEach(x->{
			if (x.getRentalprices().getRentPrice()==rentalprices) {
				System.out.println(x.getName());
			}
		});
		return Result;
	}
}
