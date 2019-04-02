package Lexicon.Rent_Cars.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.repository.ContactInfoRepo;

@Service
@Transactional
public class ContactsInfo_Services_Impl implements ContactsInfo_Services{
	
	private ContactInfoRepo contactsinfo_repo;

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
	public ContactsInfo Save(ContactsInfo salesPerson) {
		
		return contactsinfo_repo.save(salesPerson);
	}

	@Override
	public boolean Remove(int id) {
		contactsinfo_repo.deleteById(id);;
		return contactsinfo_repo.existsById(id);
	}
	
	

}
