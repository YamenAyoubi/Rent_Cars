package Lexicon.Rent_Cars.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Branches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Branch_ID")
	private List<Cars> Cars_Lists = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, orphanRemoval = true)
	@JoinColumn(name = "Branch_ID")
	private List<SalesPerson> SalesPersons_list = new ArrayList<>();

	public Branches(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Branches() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Cars> getCars_Lists() {
		return Cars_Lists;
	}

	public void setCars_Lists(List<Cars> cars_Lists) {
		Cars_Lists = cars_Lists;
	}

	public int getId() {
		return id;
	}

	public List<SalesPerson> getSalesPersons_list() {
		return SalesPersons_list;
	}

	public void setSalesPersons_list(List<SalesPerson> salesPersons_list) {
		SalesPersons_list = salesPersons_list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cars_Lists == null) ? 0 : Cars_Lists.hashCode());
		result = prime * result + ((SalesPersons_list == null) ? 0 : SalesPersons_list.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (Cars_Lists == null) {
			if (other.Cars_Lists != null)
				return false;
		} else if (!Cars_Lists.equals(other.Cars_Lists))
			return false;
		if (SalesPersons_list == null) {
			if (other.SalesPersons_list != null)
				return false;
		} else if (!SalesPersons_list.equals(other.SalesPersons_list))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Branches [ name=" + name + ", city=" + city + "]";
	}

}
