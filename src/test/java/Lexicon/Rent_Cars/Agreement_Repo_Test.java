package Lexicon.Rent_Cars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class Agreement_Repo_Test {
	
	@Autowired private CarsRepo test_cars_repo;
	@Autowired private AgreementRepo test_agreement_repo;
	@Autowired private BranchesRepo test_branch_repo;
	@Autowired private ClientsRepo test_client_repo;
	@Autowired private ContactInfoRepo test_cont_repo;
	@Autowired private MoreDescriptionsRepo test_Mor_repo;
	@Autowired private RentalPricesRepo test_rentPrices_repo;
	@Autowired private SalesPersonRepo test_sales_repo;
	
	private Agreement Test_agreement;
	private Agreement Test_agreement2;
	private Branches Test_branch;
	private Cars Test_Car;
	private Client Test_client;
	private ContactsInfo Test_cont1;
	private ContactsInfo Test_cont2;
	private MoreDescriptions Test_Mor;
	private RentalPrices Test_Rent_Prices;
	private SalesPerson Test_Sales_Person;
	
	
	@Before
	public void init() {
		Branches Bra1=new Branches("Vaxjo","Vaxjo");
		Cars car1 = new Cars("Opel");
		Client client1=new Client("Erik","Eriksson");	
		ContactsInfo cont1=new ContactsInfo("vaxjo", "070123456");
		ContactsInfo cont2=new ContactsInfo("vaxjoo", "0701233356");
		MoreDescriptions  Mor1=new MoreDescriptions("Volvo","silver","2018","6 seats",true,"some scratches at front");
		RentalPrices Price1=new RentalPrices(230);
		SalesPerson Sales1=new SalesPerson("YAMEN", "Ayou");

		Test_Car=test_cars_repo.save(car1);
		Test_client=test_client_repo.save(client1);
		Test_branch=test_branch_repo.save(Bra1);
		Test_cont1=test_cont_repo.save(cont1);
		Test_cont2=test_cont_repo.save(cont2);
		Test_Mor=test_Mor_repo.save(Mor1);
		Test_Rent_Prices=test_rentPrices_repo.save(Price1);
		Test_Sales_Person=test_sales_repo.save(Sales1);
		
		Test_Car.setBranch(Test_branch);
		Test_client.setContactsInfo(Test_cont1);
		Test_Sales_Person.setContactsInfo(Test_cont2);
		Test_Car.setRentalprices(Test_Rent_Prices);
		Test_Car.setMore_Descriptions(Test_Mor);
		
		Test_agreement=new Agreement(true, true, Test_Car, Test_client, Test_Sales_Person, 20);
		test_agreement_repo.save(Test_agreement);
		Test_agreement2=new Agreement();
	}
	
	@Test
	public void test_findByid() {
		Agreement expected = Test_agreement;
		Optional<Agreement> actual =  test_agreement_repo.findById(1);
	assertEquals(expected, actual.get());
	
	}

}
