package Lexicon.Rent_Cars.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Agreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean navigation;
	private boolean baby_chair;
	private int rent_period;
	private double total_cost;
	private boolean Paid;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "Car_ID")
	private Cars selected_Car;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private Client client_Details;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private SalesPerson sales_Person;

	private int baby_chair_cost;
	private int navigation_cost;
	private final LocalDateTime creationDateTime;
	private final LocalDateTime endingDateTime;

	public Agreement(boolean navigation, boolean baby_chair, Cars selected_Car, Client client_Details,
			SalesPerson sales_Person, int rent_period) {
		super();
		this.navigation = navigation;
		this.baby_chair = baby_chair;
		this.selected_Car = selected_Car;
		this.client_Details = client_Details;
		this.sales_Person = sales_Person;
		this.rent_period = rent_period;
		creationDateTime = LocalDateTime.now();
		endingDateTime = creationDateTime.plusDays(rent_period);
		countCost();
		Discount();
	}

	public Agreement() {
		creationDateTime = LocalDateTime.now();
		endingDateTime = creationDateTime.plusDays(rent_period);
	}

	private void countCost() {

		if (navigation == true) {
			navigation_cost = 30 * rent_period;

		} else {
			navigation_cost = 0;
		}

		if (baby_chair == true) {
			baby_chair_cost = 20 * rent_period;
		} else {
			baby_chair_cost = 0;
		}
		total_cost = selected_Car.getRentalprices().getRentPrice() * rent_period + baby_chair_cost + navigation_cost;
	}

	private void Discount() {

		if (rent_period <= 30) {

			total_cost = total_cost * 100 / 100;

		} else if (rent_period > 30) {
			total_cost = total_cost * 90 / 100;
			System.out.println("You Got Discount 10 % ");
		} else if (rent_period > 60) {

			total_cost = total_cost * 80 / 100;
			System.out.println("You Got Discount 20 % ");
		} else {
			total_cost = total_cost * 70 / 100;
			System.out.println("You Got Discount 30 % ");
		}
	}

	public boolean isNavigation() {
		return navigation;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	public boolean isBaby_chair() {
		return baby_chair;
	}

	public void setBaby_chair(boolean baby_chair) {
		this.baby_chair = baby_chair;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public Cars getSelected_Car() {
		return selected_Car;
	}

	public void setSelected_Car(Cars selected_Car) {
		this.selected_Car = selected_Car;
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

	public int getBaby_chair_cost() {
		return baby_chair_cost;
	}

	public void setBaby_chair_cost(int baby_chair_cost) {
		this.baby_chair_cost = baby_chair_cost;
	}

	public int getNavigation_cost() {
		return navigation_cost;
	}

	public void setNavigation_cost(int navigation_cost) {
		this.navigation_cost = navigation_cost;
	}

	public int getId() {
		return id;
	}

	public int getRent_period() {
		return rent_period;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public LocalDateTime getEndingDateTime() {
		return endingDateTime;
	}

	public void setRent_period(int rent_period) {
		this.rent_period = rent_period;
	}
	
	

	public boolean isPaid() {
		return Paid;
	}

	public void setPaid(boolean paid) {
		Paid = paid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Paid ? 1231 : 1237);
		result = prime * result + (baby_chair ? 1231 : 1237);
		result = prime * result + baby_chair_cost;
		result = prime * result + ((client_Details == null) ? 0 : client_Details.hashCode());
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((endingDateTime == null) ? 0 : endingDateTime.hashCode());
		result = prime * result + id;
		result = prime * result + (navigation ? 1231 : 1237);
		result = prime * result + navigation_cost;
		result = prime * result + rent_period;
		result = prime * result + ((sales_Person == null) ? 0 : sales_Person.hashCode());
		result = prime * result + ((selected_Car == null) ? 0 : selected_Car.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Paid != other.Paid)
			return false;
		if (baby_chair != other.baby_chair)
			return false;
		if (baby_chair_cost != other.baby_chair_cost)
			return false;
		if (client_Details == null) {
			if (other.client_Details != null)
				return false;
		} else if (!client_Details.equals(other.client_Details))
			return false;
		if (creationDateTime == null) {
			if (other.creationDateTime != null)
				return false;
		} else if (!creationDateTime.equals(other.creationDateTime))
			return false;
		if (endingDateTime == null) {
			if (other.endingDateTime != null)
				return false;
		} else if (!endingDateTime.equals(other.endingDateTime))
			return false;
		if (id != other.id)
			return false;
		if (navigation != other.navigation)
			return false;
		if (navigation_cost != other.navigation_cost)
			return false;
		if (rent_period != other.rent_period)
			return false;
		if (sales_Person == null) {
			if (other.sales_Person != null)
				return false;
		} else if (!sales_Person.equals(other.sales_Person))
			return false;
		if (selected_Car == null) {
			if (other.selected_Car != null)
				return false;
		} else if (!selected_Car.equals(other.selected_Car))
			return false;
		if (Double.doubleToLongBits(total_cost) != Double.doubleToLongBits(other.total_cost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agreement [id=" + id + ", navigation=" + navigation + ", baby_chair=" + baby_chair + ", total_cost="
				+ total_cost + ", selected_Car=" + selected_Car + ", client_Details=" + client_Details
				+ ", sales_Person=" + sales_Person + ", baby_chair_cost=" + baby_chair_cost + ", navigation_cost="
				+ navigation_cost + ", creationDateTime=" + creationDateTime + ", endingDateTime=" + endingDateTime
				+ "]";
	}

}
