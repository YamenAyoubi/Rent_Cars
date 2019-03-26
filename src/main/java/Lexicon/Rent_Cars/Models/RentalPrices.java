package Lexicon.Rent_Cars.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RentalPrices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private int MonthlyRent;
	private int DailyRent;
	private int Hourly;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;

	public RentalPrices(int monthlyRent, int dailyRent, int hourly) {
		super();
		MonthlyRent = monthlyRent;
		DailyRent = dailyRent;
		Hourly = hourly;
	}
	
	public RentalPrices() {}

	public int getMonthlyRent() {
		return MonthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		MonthlyRent = monthlyRent;
	}

	public int getDailyRent() {
		return DailyRent;
	}

	public void setDailyRent(int dailyRent) {
		DailyRent = dailyRent;
	}

	public int getHourly() {
		return Hourly;
	}

	public void setHourly(int hourly) {
		Hourly = hourly;
	}

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + DailyRent;
		result = prime * result + Hourly;
		result = prime * result + ID;
		result = prime * result + MonthlyRent;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
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
		if (DailyRent != other.DailyRent)
			return false;
		if (Hourly != other.Hourly)
			return false;
		if (ID != other.ID)
			return false;
		if (MonthlyRent != other.MonthlyRent)
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RentalPrices [ID=" + ID + ", MonthlyRent=" + MonthlyRent + ", DailyRent=" + DailyRent + ", Hourly="
				+ Hourly + ", cars=" + cars + "]";
	}

	
}
