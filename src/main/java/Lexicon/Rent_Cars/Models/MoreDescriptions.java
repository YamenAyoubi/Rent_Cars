package Lexicon.Rent_Cars.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MoreDescriptions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private boolean Fuel;
	private boolean Auto;
	private boolean Rented;
	private String More_Details;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;
}
