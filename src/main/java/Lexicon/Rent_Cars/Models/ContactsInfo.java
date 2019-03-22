package Lexicon.Rent_Cars.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ContactsInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Address;
	private String ContactNumber;

	@OneToOne(cascade=CascadeType.ALL)
	private Client client;
	@OneToOne(cascade=CascadeType.ALL)
	private SalesPerson salesPerson;
}
