package Lexicon.Rent_Cars.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;
import Lexicon.Rent_Cars.repository.MoreDescriptionsRepo;

@Service
@Transactional
public class MoreDes_Services_Impl implements MoreDes_Services{

	private MoreDescriptionsRepo MoreDes_repo;
	private Cars car;

	@Autowired
	public MoreDes_Services_Impl(MoreDescriptionsRepo moreDes_repo) {
		super();
		MoreDes_repo = moreDes_repo;
	}

	@Override
	public MoreDescriptions Save(MoreDescriptions MoreDes) {
		
		return MoreDes_repo.save(MoreDes);
	}

	@Override
	public boolean Remove(int id) {
		MoreDes_repo.deleteById(id);
		return MoreDes_repo.existsById(id);
	}
	
	public void AddMoreInfoToCars  (MoreDescriptions MoreDes) {
		car.setMore_Descriptions(MoreDes);
		
		
	}

}
