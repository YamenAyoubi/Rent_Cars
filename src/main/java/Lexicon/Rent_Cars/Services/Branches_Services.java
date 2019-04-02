package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Branches;

public interface Branches_Services {

	Branches save(Branches branch);
	
	boolean remove(int id);
	
	List<Branches> findAll();
	
}
