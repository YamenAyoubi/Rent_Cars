package Lexicon.Rent_Cars.repository;

import org.springframework.data.repository.CrudRepository;

import Lexicon.Rent_Cars.entity.Payment;

public interface PaymenRepo extends CrudRepository<Payment, Integer> {

}
