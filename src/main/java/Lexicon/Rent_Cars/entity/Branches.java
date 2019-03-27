package Lexicon.Rent_Cars.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Branches {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Name;
	private String City;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<Cars> branchCars=new ArrayList<>();
	@OneToOne(cascade=CascadeType.ALL)
	private Client client;
	@OneToOne(cascade=CascadeType.ALL)
	private SalesPerson salesPerson;

	public Branches(String name, String city) {
		super();
		Name = name;
		City = city;
	}
	
	public Branches() {}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public List<Cars> getBranchCars() {
		return branchCars;
	}

	public void setBranchCars(List<Cars> branchCars) {
		this.branchCars = branchCars;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SalesPerson getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((branchCars == null) ? 0 : branchCars.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((salesPerson == null) ? 0 : salesPerson.hashCode());
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
		Branches other = (Branches) obj;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (ID != other.ID)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (branchCars == null) {
			if (other.branchCars != null)
				return false;
		} else if (!branchCars.equals(other.branchCars))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (salesPerson == null) {
			if (other.salesPerson != null)
				return false;
		} else if (!salesPerson.equals(other.salesPerson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Branches [Name=" + Name + ", City=" + City + "]";
	}



	
}
