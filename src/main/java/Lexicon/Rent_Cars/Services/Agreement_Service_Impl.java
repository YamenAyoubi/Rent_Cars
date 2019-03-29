package Lexicon.Rent_Cars.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.repository.AgreementRepo;


@Service
@Transactional
public class Agreement_Service_Impl implements Agreement_Services{
	
	
	private AgreementRepo agreement_Repo;

	@Autowired
	public Agreement_Service_Impl(AgreementRepo agreement_Repo) {
		super();
		this.agreement_Repo = agreement_Repo;
	}
	
	
	

}
