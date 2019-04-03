package Lexicon.Rent_Cars.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.SalesPersonRepo;

@Service
@Transactional
public class SalesPerson_Services_Impl implements SalesPerson_Services{

	private SalesPersonRepo salesPerson_Repo;
	private AgreementRepo agreement_Repo;
	private Agreement agreement;
	
	@Autowired
	public SalesPerson_Services_Impl(SalesPersonRepo salesPerson_Repo) {
		super();
		this.salesPerson_Repo = salesPerson_Repo;
	}

	@Override
	public List<SalesPerson> FindAll() {
		
		return (List<SalesPerson>) salesPerson_Repo.findAll();
	}

	@Override
	public SalesPerson Save(SalesPerson salesPerson) {
		
		return salesPerson_Repo.save(salesPerson);
	}

	@Override
	public boolean Remove(int id) {
		salesPerson_Repo.deleteById(id);
		return salesPerson_Repo.existsById(id);
	}
	
	public void AddSalesPersonToAgreement (SalesPerson salesperson) {
		agreement.setSales_Person(salesperson);
		agreement_Repo.save(agreement);
	}
		

}
