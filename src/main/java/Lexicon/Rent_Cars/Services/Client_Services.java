package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Client;

public interface Client_Services {

	Client save(Client client);
	
	boolean remove(int id);
	
	List<Client> findAll();
	
	void AddClientToAgreement (Client client);
}
