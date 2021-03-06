package Lexicon.Rent_Cars.Services;

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
	public Client findById_client(int id) {
		return client_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public List<SalesPerson> FindAll_SalesPerson() {

		return (List<SalesPerson>) salesPerson_Repo.findAll();
	}

	@Override
	public SalesPerson findById_SalesPerson(int id) {
		return salesPerson_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public Branches findById_Branch(int id) {
		return branch_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public SalesPerson Save_SalesPerson(SalesPerson salesPerson) {
		return salesPerson_Repo.save(salesPerson);
	}

	@Override
	public boolean Remove_SalesPerson(int id) {
		salesPerson_Repo.deleteById(id);
		return salesPerson_Repo.existsById(id);
	}

	@Override
	public boolean AddSalesPersonToBranch(int salesPerson_id, int branche_id) {

		SalesPerson selected_SalesPerson = findById_SalesPerson(salesPerson_id);
		Branches selected_Branch = findById_Branch(branche_id);
		return selected_Branch.getSalesPersons_list().add(selected_SalesPerson);
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
		return contactsinfo_repo.existsById(id);
	}

	@Override
	public ContactsInfo findById_Contact(int id) {
		return contactsinfo_repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public void AddContactInfoToClient(int contactsInfo_id, int client_id) {

		Client selected_client = findById_client(client_id);
		ContactsInfo selected_Contact = findById_Contact(contactsInfo_id);
		selected_client.setContactsInfo(selected_Contact);
		client_Repo.save(selected_client);
	}

	@Override
	public void AddContactInfoToSalesPerson(int contactsInfo_id, int salesPerson_id) {

		SalesPerson selected_SalesPerson = findById_SalesPerson(salesPerson_id);
		ContactsInfo selected_Contact = findById_Contact(contactsInfo_id);
		selected_SalesPerson.setContactsInfo(selected_Contact);
		salesPerson_Repo.save(selected_SalesPerson);
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

	@Override
	public Branches sales_persons_List_atbranch(Branches branch) {
		List<SalesPerson> SalesPerson_List = branch.getSalesPersons_list();
		System.out.println(SalesPerson_List);
		return branch;
	}

}
