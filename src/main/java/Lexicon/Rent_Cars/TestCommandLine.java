package Lexicon.Rent_Cars;

import org.dom4j.Branch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
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

	


	@Override
	public void run(String... args) throws Exception {
		
		Cars Opel = cars_repo.save(new Cars("Opel"));
		Cars Volvo = cars_repo.save(new Cars("Volvo"));
		Branches Vaxjo = branches_repo.save(new Branches("Vaxjo Branch" ,"Vaxjo"));
		Client Erik = client_repo.save(new Client("Erik","Eriksoon"));
		ContactsInfo info1=contact_info_repo.save(new ContactsInfo("Vaxjo","1234567"));
		
		System.out.println(Opel);
		System.out.println(Volvo);
		
		
	}

}
