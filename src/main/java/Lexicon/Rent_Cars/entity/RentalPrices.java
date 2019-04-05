package Lexicon.Rent_Cars.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class RentalPrices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rentPrice;
	

	public RentalPrices(int rentPrice) {
		super();
		this.rentPrice = rentPrice;
	}


	public RentalPrices() {}


	public int getRentPrice() {
		return rentPrice;
	}


	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getId() {
		return id;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + rentPrice;
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
		RentalPrices other = (RentalPrices) obj;
		if (id != other.id)
			return false;
		if (rentPrice != other.rentPrice)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RentalPrices [rentPrice=" + rentPrice + "]";
	}

	

	
}
