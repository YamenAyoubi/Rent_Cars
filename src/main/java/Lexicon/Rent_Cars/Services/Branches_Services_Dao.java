package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.SalesPerson;

public interface Branches_Services_Dao {

	Branches save(Branches branch);
	
	boolean remove(int id);
	
	List<Branches> findAll();


	
}
