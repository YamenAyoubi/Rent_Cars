package Lexicon.Rent_Cars.repository;

import org.springframework.data.repository.CrudRepository;

import Lexicon.Rent_Cars.entity.Client;

public interface ClientsRepo extends CrudRepository<Client, Integer> {

}
