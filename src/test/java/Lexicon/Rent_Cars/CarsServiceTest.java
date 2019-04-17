//package Lexicon.Rent_Cars;
//
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import Lexicon.Rent_Cars.Services.Cars_Services_Dao;
//import Lexicon.Rent_Cars.Services.Cars_Services_Impl;
//import Lexicon.Rent_Cars.entity.Cars;
//import Lexicon.Rent_Cars.entity.MoreDescriptions;
//import Lexicon.Rent_Cars.entity.RentalPrices;
//import Lexicon.Rent_Cars.repository.AgreementRepo;
//import Lexicon.Rent_Cars.repository.BranchesRepo;
//import Lexicon.Rent_Cars.repository.CarsRepo;
//import Lexicon.Rent_Cars.repository.MoreDescriptionsRepo;
//import Lexicon.Rent_Cars.repository.RentalPricesRepo;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class CarsServiceTest {
//	
//	@TestConfiguration
//	static class TestConfigurationContex {
//		@Bean
//		public Cars_Services_Dao customorSevice(CarsRepo cars_Repo, AgreementRepo agreement_Repo, MoreDescriptionsRepo moreDes_repo,
//				RentalPricesRepo rentalPrices_repo, BranchesRepo branch_Repo) {
//			return new Cars_Services_Impl(cars_Repo, agreement_Repo,moreDes_repo,rentalPrices_repo,branch_Repo);
//		}
//	}
//	@Autowired
//	private Cars_Services_Dao TestCar;
//	private List<Cars> resultList;
//	private Cars car1;
//	
//	@Before
//	public void init() {
//		
//		MoreDescriptions  Mor1=new MoreDescriptions("Volvo","silver","2018","6 seats",true,"some scratches at front");
//		RentalPrices Price1=new RentalPrices(230);
//		Cars car1 = new Cars("Opel",Price1,Mor1);
//		car1.setRentalprices(Price1);
//		List<Cars> resultList = new ArrayList<>();
//		resultList.add(car1);
//		TestCar.save_Car(car1);
//
//	}
//	
//
//}
