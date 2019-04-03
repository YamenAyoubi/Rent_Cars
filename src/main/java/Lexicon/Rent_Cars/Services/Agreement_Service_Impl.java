package Lexicon.Rent_Cars.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.CarsRepo;


@Service
@Transactional
public class Agreement_Service_Impl implements Agreement_Services{
	
	
	private AgreementRepo agreement_Repo;
	

	@Autowired
	public Agreement_Service_Impl(AgreementRepo agreement_Repo) {
		super();
		this.agreement_Repo = agreement_Repo;
	}

	@Override
	public Agreement findById(int id) {
		Optional<Agreement> Result = agreement_Repo.findById(id);
		if (Result.isPresent()) {
			return Result.get();}
		return null;
	}

	@Override
	public List<Agreement> findAll() {	
		return (List<Agreement>) agreement_Repo.findAll();
	}

	@Override
	public Agreement save(Agreement agreement) {
		return agreement_Repo.save(agreement);
	}

	@Override
	public boolean remove(int id) {
		agreement_Repo.deleteById(id);
		return agreement_Repo.existsById(id);
	}
	
}
