package Lexicon.Rent_Cars.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.SalesPerson;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.ClientsRepo;
import Lexicon.Rent_Cars.repository.SalesPersonRepo;

@Service
@Transactional
public class Agreement_Service_Impl implements Agreement_Services_Dao {

	private AgreementRepo agreement_Repo;
	private ClientsRepo client_Repo;
	private SalesPersonRepo salesPerson_Repo;

	@Autowired
	public Agreement_Service_Impl(AgreementRepo agreement_Repo) {
		super();
		this.agreement_Repo = agreement_Repo;
	}

	@Override
	public Agreement findById_agreement(int id) {
		return agreement_Repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public List<Agreement> findAll_agreement() {
		return (List<Agreement>) agreement_Repo.findAll();
	}

	@Override
	public Agreement save_Agreement(Agreement agreement) {
		return agreement_Repo.save(agreement);
	}

	@Override
	public boolean remove(int id) {
		agreement_Repo.deleteById(id);
		return agreement_Repo.existsById(id);
	}

	@Override
	public Agreement AddClientToAgreement(int agreement_id, int client_id) {

		Optional<Client> selected_client = client_Repo.findById(client_id);
		Agreement selected_agreement = findById_agreement(agreement_id);
		if (selected_agreement.getClient_Details() == null) {
			selected_agreement.setClient_Details(selected_client.get());
		} else {
			System.out.println("Agreement Has Valid Client");
		}
		return save_Agreement(selected_agreement);
	}

	@Override
	public Agreement AddSalesPersonToAgreement(int agreement_id, int salesPerson_id) {
		Agreement selected_agreement = findById_agreement(agreement_id);
		Optional<SalesPerson> selected_salesPerson = salesPerson_Repo.findById(salesPerson_id);
		if (selected_agreement.getSales_Person() == null) {
			selected_agreement.setSales_Person(selected_salesPerson.get());
		} else {

			System.out.println("Agreement Has Valid Sales Person");
		}

		return save_Agreement(selected_agreement);
	}

	public List<Agreement> FindByRentPeriod(int rent_period) {

		List<Agreement> Result = new ArrayList<>();

		Result.forEach(x -> {
			if (x.getRent_period() == rent_period) {
				System.out.println(x.getId());
			}
		});
		return Result;
	}

}
