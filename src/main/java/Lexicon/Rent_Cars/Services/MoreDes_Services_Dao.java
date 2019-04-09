package Lexicon.Rent_Cars.Services;

import Lexicon.Rent_Cars.entity.MoreDescriptions;

public interface MoreDes_Services_Dao {
	
	MoreDescriptions Save(MoreDescriptions MoreDes);
	
	boolean Remove (int id);
	
	void AddMoreInfoToCars  (MoreDescriptions MoreDes);
}
