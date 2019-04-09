package Lexicon.Rent_Cars.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.SalesPerson;

import Lexicon.Rent_Cars.repository.SalesPersonRepo;

@Service
@Transactional
public class SalesPerson_Services_Impl implements SalesPerson_Services_Dao{

	private SalesPersonRepo salesPerson_Repo;
	private Branches branch;

	
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
	
	@Override
	public boolean AddSalesPersonToBranch (SalesPerson salesPerson) {
		
		List<SalesPerson> SalesPerson_List = new ArrayList<>();
		branch.setSalesPersons_list(SalesPerson_List);
		
		return SalesPerson_List.add(salesPerson);	
	}
}
