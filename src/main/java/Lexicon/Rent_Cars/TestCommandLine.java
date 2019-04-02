package Lexicon.Rent_Cars;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.Services.Cars_Services_Impl;
import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.entity.RentalPrices;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.BranchesRepo;
import Lexicon.Rent_Cars.repository.CarsRepo;
import Lexicon.Rent_Cars.repository.ClientsRepo;
import Lexicon.Rent_Cars.repository.ContactInfoRepo;
import Lexicon.Rent_Cars.repository.MoreDescriptionsRepo;
import Lexicon.Rent_Cars.repository.RentalPricesRepo;
import Lexicon.Rent_Cars.repository.SalesPersonRepo;


@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine implements CommandLineRunner {

	private CarsRepo cars_repo;
	private AgreementRepo agreement_repo;
	private BranchesRepo branches_repo;
	private ClientsRepo client_repo;
	private ContactInfoRepo contact_info_repo;
	private MoreDescriptionsRepo more_des_repo;
	private RentalPricesRepo rental_prices_repo;
	private SalesPersonRepo sales_person_repo;
	private Cars_Services_Impl IMP;
	
	

	public TestCommandLine(CarsRepo cars_repo, AgreementRepo agreement_repo, BranchesRepo branches_repo,
			ClientsRepo client_repo, ContactInfoRepo contact_info_repo, MoreDescriptionsRepo more_des_repo,
			RentalPricesRepo rental_prices_repo, SalesPersonRepo sales_person_repo) {
		super();
		this.cars_repo = cars_repo;
		this.agreement_repo = agreement_repo;
		this.branches_repo = branches_repo;
		this.client_repo = client_repo;
		this.contact_info_repo = contact_info_repo;
		this.more_des_repo = more_des_repo;
		this.rental_prices_repo = rental_prices_repo;
		this.sales_person_repo = sales_person_repo;
		
	}


	@Override
	public void run(String... args) throws Exception {
		
//		Cars Opel = cars_repo.save(new Cars("Opel"));
//		Cars Volvo = cars_repo.save(new Cars("Volvo"));
//		Cars Nissan = cars_repo.save(new Cars("Nissan"));
//		Branches Vaxjo = branches_repo.save(new Branches("Vaxjo Branch" ,"Vaxjo"));
//		Client Erik = client_repo.save(new Client("Erik","Eriksoon"));
//		ContactsInfo info1=contact_info_repo.save(new ContactsInfo("Vaxjo","1234567"));
//		ContactsInfo info2=contact_info_repo.save(new ContactsInfo("Vaxjo","7654321"));
//		RentalPrices prices = rental_prices_repo.save(new RentalPrices(70));
//		RentalPrices prices1 = rental_prices_repo.save(new RentalPrices(85));
//		SalesPerson Yam = sales_person_repo.save(new SalesPerson("Yamen", "Ayo"));
//		MoreDescriptions MorInf = more_des_repo.save(new MoreDescriptions("Volvo", "balck", "2017"," 6 Seats", true, true, "Small Crash at back"));
//		MoreDescriptions MorInf1 = more_des_repo.save(new MoreDescriptions("Opel", "Silver", "2016"," 5 Seats", true, true, "Small Crash at front"));
//		MoreDescriptions MorInf3 = more_des_repo.save(new MoreDescriptions("Opel", "Silver", "2016"," 5 Seats", true, true, "Small Crash at front"));
//
//		
//		
//		Opel.setBranch(Vaxjo);
//		Volvo.setBranch(Vaxjo);
//		Opel.setRentalprices(prices);
//		Volvo.setRentalprices(prices1);
//		Volvo.setMore_Descriptions(MorInf);
//		Opel.setMore_Descriptions(MorInf1);
//		Erik.setContactsInfo(info1);
//		Yam.setContactsInfo(info2);
//		Vaxjo.setClient(Erik);
//		Vaxjo.setSalesPerson(Yam);
//		Nissan.setMore_Descriptions(MorInf3);
//		
//
//		Agreement Agre3 = agreement_repo.save(new Agreement(65, false, false, Opel, Vaxjo, Erik,Yam)); 	
//
//		Agreement Agre1 = agreement_repo.save(new Agreement(30, true, true, Volvo, Vaxjo, Erik, Yam));
//
//		Agreement Agre2 = agreement_repo.save(new Agreement(20, true, true, Opel, Vaxjo, Erik,Yam)); 
//		
//
//		
//		
//		
//		
//
//		System.out.println(Agre1);
//		System.out.println(Agre2);
//		System.out.println(Agre3);
//		System.out.println(Agre2.getToltalCost());
//		System.out.println(Agre1.getToltalCost());
//		
//		System.out.println(Agre3.getToltalCost());
//		System.out.println(cars_repo.findAll());
//		System.out.println(Nissan);
//		
//		System.out.println(IMP.findById(1));

	}

}
