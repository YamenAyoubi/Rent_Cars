package Lexicon.Rent_Cars.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.BranchesRepo;
import Lexicon.Rent_Cars.repository.CarsRepo;
import Lexicon.Rent_Cars.repository.MoreDescriptionsRepo;
import Lexicon.Rent_Cars.repository.RentalPricesRepo;

@Service
@Transactional
public class Cars_Services_Impl implements Cars_Services_Dao {

	private CarsRepo cars_Repo;
	private AgreementRepo agreement_Repo;
	private MoreDescriptionsRepo MoreDes_repo;
	private RentalPricesRepo rentalPrices_repo;
	private BranchesRepo branch_Repo;


	@Autowired
	public Cars_Services_Impl(CarsRepo cars_Repo, AgreementRepo agreement_Repo, MoreDescriptionsRepo moreDes_repo,
			RentalPricesRepo rentalPrices_repo, BranchesRepo branch_Repo) {
		super();
		this.cars_Repo = cars_Repo;
		this.agreement_Repo = agreement_Repo;
		MoreDes_repo = moreDes_repo;
		this.rentalPrices_repo = rentalPrices_repo;
		this.branch_Repo = branch_Repo;
	}

	@Override
	public Cars findById_Car(int id) {
		return cars_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public Cars save_Car(Cars car) {
		return cars_Repo.save(car);
	}

	@Override
	public boolean remove_Car(int id) {
		cars_Repo.deleteById(id);
		return cars_Repo.existsById(id);
	}

	@Override
	public List<Cars> findAll_Cars() {
		return (List<Cars>) cars_Repo.findAll();
	}

	@Override
	public boolean AddCarToAgreement(int agreement_id ,int car_id) {
		Optional<Agreement> selected_agreement  = agreement_Repo.findById(agreement_id);
		Cars selected_car = findById_Car(car_id);
		if (!selected_car.getMore_Descriptions().isRented() == true) {
			selected_agreement.get().setSelected_Car(selected_car);
			selected_agreement.get().getSelected_Car().getMore_Descriptions().setFuel(true);
			agreement_Repo.save(selected_agreement.get());
		} else {
			System.out.println("Unable to Add The Car Already Rented");
		}
		return selected_car.getMore_Descriptions().isRented() == true;
	}

	@Override
	public boolean AddCarToBranch(int car_id , int branch_id) {
		
		Cars selected_car = findById_Car(car_id);
		Optional<Branches> selected_branch = branch_Repo.findById(branch_id);
		selected_branch.filter(x -> x.getCars_Lists().add(selected_car));
		return true;	
	}

	@Override
	public List<Cars> findByNameIgnoreCase_car(String name) {

		return cars_Repo.findByNameIgnoreCase(name);
	}

	@Override
	public List<Cars> FindUnRentedCars() {

		List<Cars> Result = new ArrayList<>();

		Result.forEach(x -> {
			if (x.getMore_Descriptions().isRented() == false) {
				System.out.println(x.getName());
			}
		});
		return Result;
	}

	@Override
	public List<Cars> FindRentedCars() {
		List<Cars> Result = new ArrayList<>();
		Result.forEach(x -> {
			if (x.getMore_Descriptions().isRented() == true) {
				System.out.println(x.getName());
			}
		});
		return Result;
	}

	@Override
	public Cars Add_Rentalprice_ToCar(int rentalPrices_id,int car_id) {
		Cars selected_car =  findById_Car(car_id);
		RentalPrices rentalPrice = findById_rentalPrice(rentalPrices_id);
		selected_car.setRentalprices(rentalPrice);
		return save_Car(selected_car);
	}

	@Override
	public Cars Add_MoreDescriptions_ToCar(int moreDescriptions_id,int car_id) {
		Cars selected_car =  findById_Car(car_id);
		MoreDescriptions selected_more_des = findById_moreDes(moreDescriptions_id);
		selected_car.setMore_Descriptions(selected_more_des);
		return save_Car(selected_car);
	
	}

	@Override
	public List<Cars> findByRentalprices(int rentalprices) {

		List<Cars> Result = new ArrayList<>();

		Result.forEach(x -> {
			if (x.getRentalprices().getRentPrice() == rentalprices) {
				System.out.println(x.getName());
			}
		});
		return Result;
	}

	@Override
	public MoreDescriptions Save_More_Des(MoreDescriptions MoreDes) {

		return MoreDes_repo.save(MoreDes);
	}

	@Override
	public boolean Remove_More_Des(int id) {
		MoreDes_repo.deleteById(id);
		return MoreDes_repo.existsById(id);
	}

	@Override
	public RentalPrices Save_Rent_Price(RentalPrices rentalPrices) {
		return rentalPrices_repo.save(rentalPrices);
	}

	@Override
	public boolean Remove_Rent_Price(int id) {
		rentalPrices_repo.deleteById(id);
		return rentalPrices_repo.existsById(id);
	}
	
	@Override
	public RentalPrices findById_rentalPrice(int id) {
		return rentalPrices_repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}
	
	@Override
	public List<RentalPrices> findAll_rentalPrice() {
		return (List<RentalPrices>) rentalPrices_repo.findAll();
	}
	
	@Override
	public MoreDescriptions findById_moreDes(int id) {
		return MoreDes_repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}
	
	@Override
	public List<MoreDescriptions> findAll__moreDes() {
		return (List<MoreDescriptions>) MoreDes_repo.findAll();
	}
	
	@Override
	public void agreement_finished_CarBoolean(int agreement_id) {
		Optional<Agreement> selected_agreement  = agreement_Repo.findById(agreement_id);
		selected_agreement.get().getSelected_Car().getMore_Descriptions().setRented(false);
		selected_agreement.get().getSelected_Car().getMore_Descriptions().setFuel(true);	
		agreement_Repo.save(selected_agreement.get());
	}
}
