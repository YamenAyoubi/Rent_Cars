package Lexicon.Rent_Cars.Services;
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
		Cars result = new Cars();
		cars_Repo.findById(id);
		return result;		
	}
//	@Override
//	public List<Cars> findAll() {
//		return (List<Cars>) cars_Repo.findAll();
//	}
//	@Override
//	public List<Cars> findByName(String name){
//		return cars_Repo.findByNameIgnoreCase(name);
//	}
//	@Override
//	public boolean removeCar(int id) {
//		cars_Repo.deleteById(id);		
//		return cars_Repo.existsById(id);
//	}
//	@Override
//	public Cars save(Cars car) {
//		return cars_Repo.save(car);
//	}

}
