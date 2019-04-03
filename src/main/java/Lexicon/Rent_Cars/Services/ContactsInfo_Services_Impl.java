package Lexicon.Rent_Cars.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.CarsRepo;
import Lexicon.Rent_Cars.repository.ClientsRepo;
import Lexicon.Rent_Cars.repository.ContactInfoRepo;
import Lexicon.Rent_Cars.repository.SalesPersonRepo;

@Service
@Transactional
public class ContactsInfo_Services_Impl implements ContactsInfo_Services{
	
	private ContactInfoRepo contactsinfo_repo;
	private ClientsRepo client_repo;
	private SalesPersonRepo sales_person_repo;
	private Client client ;
	private SalesPerson sales_person;

	@Autowired
	public ContactsInfo_Services_Impl(ContactInfoRepo contactsinfo_repo) {
		super();
		this.contactsinfo_repo = contactsinfo_repo;
	}

	@Override
	public List<ContactsInfo> FindAll() {
		
		return (List<ContactsInfo>) contactsinfo_repo.findAll();
	}


	@Override
	public ContactsInfo Save(ContactsInfo contactsInfo) {
		
		return contactsinfo_repo.save(contactsInfo);
	}

	@Override
	public boolean Remove(int id) {
		contactsinfo_repo.deleteById(id);;
		return contactsinfo_repo.existsById(id);
	}
	
	public void AddContactInfoToClient  (ContactsInfo contactsInfo) {
		client.setContactsInfo(contactsInfo);
		client_repo.save(client);
	}
	public void AddContactInfoToSalesPerson (ContactsInfo contactsInfo) {
		sales_person.setContactsInfo(contactsInfo);
		sales_person_repo.save(sales_person);
	}
}
