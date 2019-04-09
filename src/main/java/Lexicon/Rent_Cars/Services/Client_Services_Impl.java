package Lexicon.Rent_Cars.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.repository.ClientsRepo;

@Service
@Transactional
public class Client_Services_Impl implements Client_Services_Dao{

	private ClientsRepo client_Repo;

	
	
	@Autowired
	public Client_Services_Impl(ClientsRepo client_Repo) {
		super();
		this.client_Repo = client_Repo;
	}

	@Override
	public Client save(Client client) {
		
		return client_Repo.save(client);
	}

	@Override
	public boolean remove(int id) {
		client_Repo.deleteById(id);
		return client_Repo.existsById(id);
	}

	@Override
	public List<Client> findAll() {
		
		return (List<Client>) client_Repo.findAll();
	}
	
	
}
