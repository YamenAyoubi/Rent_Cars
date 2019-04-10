package Lexicon.Rent_Cars.Services;

import java.util.List;

import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;

public interface SalesPerson_Services_Dao {

	List<SalesPerson> FindAll_SalesPerson();

	SalesPerson Save_SalesPerson(SalesPerson salesPerson);

	boolean Remove_SalesPerson(int id);

	boolean AddSalesPersonToBranch(SalesPerson salesPerson,int id);

	Client save_Client(Client client);

	boolean remove_Client(int id);

	List<Client> findAll_Clients();

	List<ContactsInfo> FindAll_Contact();

	ContactsInfo Save_Contact(ContactsInfo contactsInfo);

	boolean Remove_Contact(int id);

	void AddContactInfoToClient(ContactsInfo contactsInfo,int id);

	void AddContactInfoToSalesPerson(ContactsInfo contactsInfo,int id);

	Branches save_Branch(Branches branch);

	boolean remove_Branch(int id);

	List<Branches> findAll_Branches();

	Client findById_client(int id);

	SalesPerson findById_SalesPerson(int id);

	Branches findById_Branch(int id);

}