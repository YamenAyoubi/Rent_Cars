package Lexicon.Rent_Cars.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class RentalPrices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rentPrice;
	

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private Cars car;

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
	
	

	public Cars getCar() {
		return car;
	}


	public void setCar(Cars car) {
		this.car = car;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
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
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
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
