package Lexicon.Rent_Cars.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.AgreementRepo;



@Service
@Transactional
public class Agreement_Service_Impl implements Agreement_Services{
	
	
	private AgreementRepo agreement_Repo;
	private Agreement agreement;
	

	@Autowired
	public Agreement_Service_Impl(AgreementRepo agreement_Repo) {
		super();
		this.agreement_Repo = agreement_Repo;
	}

	@Override
	public Agreement findById(int id) {
		return agreement_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public List<Agreement> findAll() {	
		return (List<Agreement>) agreement_Repo.findAll();
	}

	@Override
	public Agreement CreatAgreement(Agreement agreement) {
		return agreement_Repo.save(agreement);
	}

	@Override
	public boolean remove(int id) {
		agreement_Repo.deleteById(id);
		return agreement_Repo.existsById(id);
	}
	@Override
	public Agreement AddClientToAgreement (Client client) {
	
		if (agreement.getClient_Details()==null) {
			agreement.setClient_Details(client);
		}else {
			
			System.out.println("Agreement Has Valid Client");
		}
		
		return CreatAgreement(agreement);	
	}
	@Override
	public Agreement AddSalesPersonToAgreement (SalesPerson salesPerson) {
	
		if (agreement.getSales_Person()==null) {
			agreement.setSales_Person(salesPerson);
		}else {
			
			System.out.println("Agreement Has Valid Sales Person");
		}
		
		return CreatAgreement(agreement);	
	}
	
}
