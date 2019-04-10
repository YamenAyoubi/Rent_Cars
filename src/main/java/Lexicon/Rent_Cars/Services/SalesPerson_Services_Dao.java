package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;

public interface SalesPerson_Services_Dao {

	List<SalesPerson> FindAll();

	SalesPerson Save(SalesPerson salesPerson);

	boolean Remove(int id);

	boolean AddSalesPersonToBranch(SalesPerson salesPerson);

	Client save_Client(Client client);

	boolean remove_Client(int id);

	List<Client> findAll_Clients();

	List<ContactsInfo> FindAll_Contact();

	ContactsInfo Save_Contact(ContactsInfo contactsInfo);

	boolean Remove_Contact(int id);

	void AddContactInfoToClient(ContactsInfo contactsInfo);

	void AddContactInfoToSalesPerson(ContactsInfo contactsInfo);

	Branches save_Branch(Branches branch);

	boolean remove_Branch(int id);

	List<Branches> findAll_Branches();

}