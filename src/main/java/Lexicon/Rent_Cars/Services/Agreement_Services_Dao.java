package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Agreement;


public interface Agreement_Services_Dao {

	Agreement findById_agreement(int id);

	List<Agreement> findAll_agreement();

	boolean remove(int id);

	Agreement save_Agreement(Agreement agreement);

	Agreement AddClientToAgreement(int agreement_id, int client_id);

	Agreement AddSalesPersonToAgreement(int agreement_id, int salesPerson_id);

	List<Agreement> FindByRentPeriod(int rent_period);
}
