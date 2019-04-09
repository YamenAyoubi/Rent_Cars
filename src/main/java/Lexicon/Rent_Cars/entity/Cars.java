package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private RentalPrices rentalprices;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private MoreDescriptions more_Descriptions;

	public Cars(String name, RentalPrices rentalprices, MoreDescriptions more_Descriptions) {
		super();
		this.name = name;
		this.rentalprices = rentalprices;
		this.more_Descriptions = more_Descriptions;
	}

	public Cars() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RentalPrices getRentalprices() {
		return rentalprices;
	}

	public void setRentalprices(RentalPrices rentalprices) {
		this.rentalprices = rentalprices;
	}

	public MoreDescriptions getMore_Descriptions() {
		return more_Descriptions;
	}

	public void setMore_Descriptions(MoreDescriptions more_Descriptions) {
		this.more_Descriptions = more_Descriptions;
	}


	public int getId() {
		return id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((more_Descriptions == null) ? 0 : more_Descriptions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rentalprices == null) ? 0 : rentalprices.hashCode());
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
		Cars other = (Cars) obj;
		if (id != other.id)
			return false;
		if (more_Descriptions == null) {
			if (other.more_Descriptions != null)
				return false;
		} else if (!more_Descriptions.equals(other.more_Descriptions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rentalprices == null) {
			if (other.rentalprices != null)
				return false;
		} else if (!rentalprices.equals(other.rentalprices))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cars [ name=" + name  + ", rentalprices=" + rentalprices
				+ ", more_Descriptions=" + more_Descriptions + "]";
	}

	
}
