package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.SalesPerson;


public interface Agreement_Services_Dao {

	
	Agreement findById(int id);
	
	List<Agreement> findAll();
	
	boolean remove(int id);

	Agreement CreatAgreement(Agreement agreement);
	
	Agreement AddClientToAgreement (Agreement agreement ,Client client);

	Agreement AddSalesPersonToAgreement(Agreement agreement ,SalesPerson salesPerson);
	
	List<Agreement> FindByRentPeriod (int rent_period);
}
