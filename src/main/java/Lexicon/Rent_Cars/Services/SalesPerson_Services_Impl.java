package Lexicon.Rent_Cars.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.BranchesRepo;
import Lexicon.Rent_Cars.repository.ClientsRepo;
import Lexicon.Rent_Cars.repository.ContactInfoRepo;
import Lexicon.Rent_Cars.repository.SalesPersonRepo;

@Service
@Transactional
public class SalesPerson_Services_Impl implements SalesPerson_Services_Dao {

	private SalesPersonRepo salesPerson_Repo;
	private ClientsRepo client_Repo;
	private ContactInfoRepo contactsinfo_repo;
	private BranchesRepo branch_Repo;
	private Client client;
	private SalesPerson sales_person;
	private Branches branch;

	@Autowired
	public SalesPerson_Services_Impl(SalesPersonRepo salesPerson_Repo, ClientsRepo client_Repo,
			ContactInfoRepo contactsinfo_repo, BranchesRepo branch_Repo) {
		super();
		this.salesPerson_Repo = salesPerson_Repo;
		this.client_Repo = client_Repo;
		this.contactsinfo_repo = contactsinfo_repo;
		this.branch_Repo = branch_Repo;
	}

	@Override
	public List<SalesPerson> FindAll() {

		return (List<SalesPerson>) salesPerson_Repo.findAll();
	}

	@Override
	public SalesPerson Save(SalesPerson salesPerson) {

		return salesPerson_Repo.save(salesPerson);
	}

	@Override
	public boolean Remove(int id) {
		salesPerson_Repo.deleteById(id);
		return salesPerson_Repo.existsById(id);
	}

	@Override
	public boolean AddSalesPersonToBranch(SalesPerson salesPerson) {

		List<SalesPerson> SalesPerson_List = new ArrayList<>();
		branch.setSalesPersons_list(SalesPerson_List);

		return SalesPerson_List.add(salesPerson);
	}

	@Override
	public Client save_Client(Client client) {

		return client_Repo.save(client);
	}

	@Override
	public boolean remove_Client(int id) {
		client_Repo.deleteById(id);
		return client_Repo.existsById(id);
	}

	@Override
	public List<Client> findAll_Clients() {

		return (List<Client>) client_Repo.findAll();
	}

	@Override
	public List<ContactsInfo> FindAll_Contact() {

		return (List<ContactsInfo>) contactsinfo_repo.findAll();
	}

	@Override
	public ContactsInfo Save_Contact(ContactsInfo contactsInfo) {

		return contactsinfo_repo.save(contactsInfo);
	}

	@Override
	public boolean Remove_Contact(int id) {
		contactsinfo_repo.deleteById(id);
		;
		return contactsinfo_repo.existsById(id);
	}

	@Override
	public void AddContactInfoToClient(ContactsInfo contactsInfo) {
		client.setContactsInfo(contactsInfo);
		client_Repo.save(client);
	}

	@Override
	public void AddContactInfoToSalesPerson(ContactsInfo contactsInfo) {
		sales_person.setContactsInfo(contactsInfo);
		salesPerson_Repo.save(sales_person);
	}

	@Override
	public Branches save_Branch(Branches branch) {

		return branch_Repo.save(branch);
	}

	@Override
	public boolean remove_Branch(int id) {
		branch_Repo.deleteById(id);
		return branch_Repo.existsById(id);
	}

	@Override
	public List<Branches> findAll_Branches() {
		return (List<Branches>) branch_Repo.findAll();
	}

}
