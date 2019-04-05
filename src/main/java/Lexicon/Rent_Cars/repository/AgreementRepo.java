package Lexicon.Rent_Cars.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Lexicon.Rent_Cars.entity.Agreement;

public interface AgreementRepo extends CrudRepository<Agreement, Integer> {

//	List<Agreement> findBySelected_CarIgnoreCase(String selected_Car);
//	
//	List<Agreement> findByClient_DetailsIgnoreCase(String client_Details);
//	
//	List<Agreement> findBySales_PersonIgnoreCase(String sales_Person);
}
