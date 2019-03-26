package Lexicon.Rent_Cars;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import Lexicon.Rent_Cars.Models.Branches;
import Lexicon.Rent_Cars.Models.Cars;
import Lexicon.Rent_Cars.Models.Client;
import Lexicon.Rent_Cars.Models.SalesPerson;

@Entity
public class Agreement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Agremment_ID;
	private int Rent_Period;
	private boolean Navigation;
	private boolean Baby_Chair;
	

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars_Details;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Branches branch_Car;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Client client_Details;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private SalesPerson sales_Person;

}
