package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.SalesPerson;

public interface SalesPerson_Services {
	

	List<SalesPerson> FindAll();
	
	SalesPerson Save(SalesPerson salesPerson);
	
	boolean Remove (int id);
	
	}


