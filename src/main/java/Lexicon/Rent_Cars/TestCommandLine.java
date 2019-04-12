package Lexicon.Rent_Cars;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.Services.Cars_Services_Dao;
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

	 private CarsRepo test_cars_repo;
	 private AgreementRepo test_agreement_repo;
	 private BranchesRepo test_branch_repo;
	 private ClientsRepo test_client_repo;
	 private ContactInfoRepo test_cont_repo;
	 private MoreDescriptionsRepo test_Mor_repo;
	 private RentalPricesRepo test_rentPrices_repo;
	 private SalesPersonRepo test_sales_repo;
	 
	 
		private Agreement Test_agreement;
		private Branches Test_branch;
		private Cars Test_Car;
		private Client Test_client;
		private ContactsInfo Test_cont1;
		private ContactsInfo Test_cont2;
		private MoreDescriptions Test_Mor;
		private RentalPrices Test_Rent_Prices;
		private SalesPerson Test_Sales_Person;
		
		Cars_Services_Dao impl;
	
	
	
	public TestCommandLine(CarsRepo test_cars_repo, AgreementRepo test_agreement_repo, BranchesRepo test_branch_repo,
			ClientsRepo test_client_repo, ContactInfoRepo test_cont_repo, MoreDescriptionsRepo test_Mor_repo,
			RentalPricesRepo test_rentPrices_repo, SalesPersonRepo test_sales_repo) {
		super();
		this.test_cars_repo = test_cars_repo;
		this.test_agreement_repo = test_agreement_repo;
		this.test_branch_repo = test_branch_repo;
		this.test_client_repo = test_client_repo;
		this.test_cont_repo = test_cont_repo;
		this.test_Mor_repo = test_Mor_repo;
		this.test_rentPrices_repo = test_rentPrices_repo;
		this.test_sales_repo = test_sales_repo;
	}

	@Override
	public void run(String... args) throws Exception {
			
		Branches Bra1=new Branches("Vaxjo","Vaxjo");
		ContactsInfo cont1=new ContactsInfo("vaxjo", "070123456");
		ContactsInfo cont2=new ContactsInfo("vaxjoo", "0701233356");
		Client client1=new Client("Erik","Eriksson",cont1);	
		MoreDescriptions  Mor1=new MoreDescriptions("Volvo","silver","2018","6 seats",true,"some scratches at front");
		RentalPrices Price1=new RentalPrices(230);
		RentalPrices Price2=new RentalPrices(160);
		SalesPerson Sales1=new SalesPerson("YAMEN", "Ayou",cont2);

		Cars car1 = new Cars("Opel",Price1,Mor1);
		Cars car2=new Cars("Volvo",Price2,Mor1);

		
		Test_Car=test_cars_repo.save(car1);
		Test_Car=test_cars_repo.save(car2);
		Test_client=test_client_repo.save(client1);
		Test_branch=test_branch_repo.save(Bra1);
		Test_cont1=test_cont_repo.save(cont1);
		Test_cont2=test_cont_repo.save(cont2);
		Test_Mor=test_Mor_repo.save(Mor1);
		Test_Rent_Prices=test_rentPrices_repo.save(Price1);
		Test_Sales_Person=test_sales_repo.save(Sales1);
		
		
		Test_client.setContactsInfo(Test_cont1);
		Test_Sales_Person.setContactsInfo(Test_cont2);
		Test_Car.setRentalprices(Test_Rent_Prices);
		Test_Car.setMore_Descriptions(Test_Mor);
		List<Cars> branchCars=new ArrayList<>();
		branchCars.add(car1);
		branchCars.add(car2);
		Test_branch.setCars_Lists(branchCars);
		
		
		List<SalesPerson> SalesPerson_List=new ArrayList<>();
		SalesPerson_List.add(Sales1);
		Test_branch.setSalesPersons_list(SalesPerson_List);
		
		Test_agreement=new Agreement(true, true, Test_Car, Test_client, Test_Sales_Person, 20);
		test_agreement_repo.save(Test_agreement);
		

		System.out.println(Test_agreement);
		
	}

}
