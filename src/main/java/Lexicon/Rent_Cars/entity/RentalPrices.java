package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RentalPrices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rentPrice;

	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;


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


	public Cars getCars() {
		return cars;
	}


	public void setCars(Cars cars) {
		this.cars = cars;
	}


	public int getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
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
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
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
