package Lexicon.Rent_Cars.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.repository.BranchesRepo;

@Service
@Transactional
public class Braches_Services_Impl implements Branches_Services{

	private BranchesRepo branch_Repo;
	
	@Autowired
	public Braches_Services_Impl(BranchesRepo branch_Repo) {
		super();
		this.branch_Repo = branch_Repo;
	}

	@Override
	public Branches save(Branches branch) {
		
		return branch_Repo.save(branch);
	}

	@Override
	public boolean remove(int id) {
		branch_Repo.deleteById(id);
		return branch_Repo.existsById(id);
	}

	@Override
	public List<Branches> findAll() {
		
		return (List<Branches>) branch_Repo.findAll();
	}
	
	


}
