package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.ContactsInfo;


public interface ContactsInfo_Services_Dao {
	
	
	List<ContactsInfo> FindAll();
	
	ContactsInfo Save(ContactsInfo contactsInfo);
	
	boolean Remove (int id);

}
