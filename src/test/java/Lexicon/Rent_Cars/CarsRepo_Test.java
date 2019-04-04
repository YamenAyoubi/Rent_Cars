package Lexicon.Rent_Cars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;
import Lexicon.Rent_Cars.repository.CarsRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CarsRepo_Test {
	
	@Autowired private CarsRepo test_cars_repo;
	
	private Cars TestCar;
	
	@Before
	public void init() {
		
		
		MoreDescriptions  Mor1=new MoreDescriptions("Volvo","silver","2018","6 seats",true,"some scratches at front");
		RentalPrices Price1=new RentalPrices(230);
		RentalPrices Price2=new RentalPrices(160);
		Cars car1 = new Cars("Opel",Price1,Mor1);
		Cars car2=new Cars("Volvo",Price2,Mor1);
		
		TestCar=test_cars_repo.save(car1);
		test_cars_repo.save(car2);
		
	}
	
	@Test
	public void test_findByNameIgnoreCase() {
	List<Cars> expected = Arrays.asList(TestCar);
	List<Cars> actual = test_cars_repo.findByNameIgnoreCase("oPEL");
	assertEquals(expected, actual);
	}
}
