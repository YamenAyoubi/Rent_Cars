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
	
	public Agreement(int rent_Period, boolean navigation, boolean baby_Chair, Cars cars_Details, Branches branch_Car,
			Client client_Details, SalesPerson sales_Person) {
		super();
		Rent_Period = rent_Period;
		Navigation = navigation;
		Baby_Chair = baby_Chair;
		this.cars_Details = cars_Details;
		this.branch_Car = branch_Car;
		this.client_Details = client_Details;
		this.sales_Person = sales_Person;
	}
	
	public Agreement() {}

	public int getRent_Period() {
		return Rent_Period;
	}

	public void setRent_Period(int rent_Period) {
		Rent_Period = rent_Period;
	}

	public boolean isNavigation() {
		return Navigation;
	}

	public void setNavigation(boolean navigation) {
		Navigation = navigation;
	}

	public boolean isBaby_Chair() {
		return Baby_Chair;
	}

	public void setBaby_Chair(boolean baby_Chair) {
		Baby_Chair = baby_Chair;
	}

	public Cars getCars_Details() {
		return cars_Details;
	}

	public void setCars_Details(Cars cars_Details) {
		this.cars_Details = cars_Details;
	}

	public Branches getBranch_Car() {
		return branch_Car;
	}

	public void setBranch_Car(Branches branch_Car) {
		this.branch_Car = branch_Car;
	}

	public Client getClient_Details() {
		return client_Details;
	}

	public void setClient_Details(Client client_Details) {
		this.client_Details = client_Details;
	}

	public SalesPerson getSales_Person() {
		return sales_Person;
	}

	public void setSales_Person(SalesPerson sales_Person) {
		this.sales_Person = sales_Person;
	}

	public int getAgremment_ID() {
		return Agremment_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Agremment_ID;
		result = prime * result + (Baby_Chair ? 1231 : 1237);
		result = prime * result + (Navigation ? 1231 : 1237);
		result = prime * result + Rent_Period;
		result = prime * result + ((branch_Car == null) ? 0 : branch_Car.hashCode());
		result = prime * result + ((cars_Details == null) ? 0 : cars_Details.hashCode());
		result = prime * result + ((client_Details == null) ? 0 : client_Details.hashCode());
		result = prime * result + ((sales_Person == null) ? 0 : sales_Person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agreement other = (Agreement) obj;
		if (Agremment_ID != other.Agremment_ID)
			return false;
		if (Baby_Chair != other.Baby_Chair)
			return false;
		if (Navigation != other.Navigation)
			return false;
		if (Rent_Period != other.Rent_Period)
			return false;
		if (branch_Car == null) {
			if (other.branch_Car != null)
				return false;
		} else if (!branch_Car.equals(other.branch_Car))
			return false;
		if (cars_Details == null) {
			if (other.cars_Details != null)
				return false;
		} else if (!cars_Details.equals(other.cars_Details))
			return false;
		if (client_Details == null) {
			if (other.client_Details != null)
				return false;
		} else if (!client_Details.equals(other.client_Details))
			return false;
		if (sales_Person == null) {
			if (other.sales_Person != null)
				return false;
		} else if (!sales_Person.equals(other.sales_Person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agreement [Agremment_ID=" + Agremment_ID + ", Rent_Period=" + Rent_Period + ", Navigation=" + Navigation
				+ ", Baby_Chair=" + Baby_Chair + ", cars_Details=" + cars_Details + ", branch_Car=" + branch_Car
				+ ", client_Details=" + client_Details + ", sales_Person=" + sales_Person + "]";
	}
	
	

}
