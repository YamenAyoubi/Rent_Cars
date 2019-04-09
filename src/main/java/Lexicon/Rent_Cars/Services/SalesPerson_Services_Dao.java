package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;

public interface SalesPerson_Services_Dao {
	

	List<SalesPerson> FindAll();
	
	SalesPerson Save(SalesPerson salesPerson);
	
	boolean Remove (int id);

	boolean AddSalesPersonToBranch(SalesPerson salesPerson);

	
	
	}


