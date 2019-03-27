package Lexicon.Rent_Cars.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agreement {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Agremment_ID;
	private int Rent_Period;
	private boolean Navigation;
	private boolean Baby_Chair;
	private int ToltalCost;
	

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars selected_Car;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Branches branch_Car;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Client client_Details;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private SalesPerson sales_Person;

	int Baby_Chair_Cost;
	int Navigation_Cost;

	public Agreement(int rent_Period, boolean navigation, boolean baby_Chair,Cars selected_Car,
			Branches branch_Car, Client client_Details, SalesPerson sales_Person) {
		super();
		Rent_Period = rent_Period;
		Navigation = navigation;
		Baby_Chair = baby_Chair;
		this.selected_Car = selected_Car;
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
		
		if (Rent_Period<=30) {
			ToltalCost = ToltalCost/100*100;
			
		}else if (Rent_Period>30) {
			ToltalCost = ToltalCost/90*100;
			
		}else if (Rent_Period>60) {
			ToltalCost = ToltalCost/80*100;	
	}else {
		ToltalCost = ToltalCost/70*100;
	}
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
	
	public void setToltalCost(int toltalCost) {
		if (Baby_Chair=true) {
			Baby_Chair_Cost=20*Rent_Period;
	}else { 
		Baby_Chair_Cost=0;
	}
		
		if (Navigation=true) {
			Navigation_Cost=30*Rent_Period;
		}else {
			Navigation_Cost=0;
		}
		
		ToltalCost = selected_Car.getRentalprices().getDailyRent()*Rent_Period+Baby_Chair_Cost +Navigation_Cost;
		
	}
	public int getToltalCost() {
		return ToltalCost;
	}

	public Cars getSelected_Car() {
		return selected_Car;
	}

	public void setSelected_Car(Cars selected_Car) {
		this.selected_Car = selected_Car;
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
		result = prime * result + Baby_Chair_Cost;
		result = prime * result + (Navigation ? 1231 : 1237);
		result = prime * result + Navigation_Cost;
		result = prime * result + Rent_Period;
		result = prime * result + ToltalCost;
		result = prime * result + ((branch_Car == null) ? 0 : branch_Car.hashCode());
		result = prime * result + ((client_Details == null) ? 0 : client_Details.hashCode());
		result = prime * result + ((sales_Person == null) ? 0 : sales_Person.hashCode());
		result = prime * result + ((selected_Car == null) ? 0 : selected_Car.hashCode());
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
		if (Baby_Chair_Cost != other.Baby_Chair_Cost)
			return false;
		if (Navigation != other.Navigation)
			return false;
		if (Navigation_Cost != other.Navigation_Cost)
			return false;
		if (Rent_Period != other.Rent_Period)
			return false;
		if (ToltalCost != other.ToltalCost)
			return false;
		if (branch_Car == null) {
			if (other.branch_Car != null)
				return false;
		} else if (!branch_Car.equals(other.branch_Car))
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
		if (selected_Car == null) {
			if (other.selected_Car != null)
				return false;
		} else if (!selected_Car.equals(other.selected_Car))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agreement [Agremment_ID=" + Agremment_ID + ", Rent_Period=" + Rent_Period + ", Navigation=" + Navigation
				+ ", Baby_Chair=" + Baby_Chair + ", ToltalCost=" + ToltalCost + ", selected_Car=" + selected_Car
				+ ", branch_Car=" + branch_Car + ", client_Details=" + client_Details + ", sales_Person=" + sales_Person
				+ ", Baby_Chair_Cost=" + Baby_Chair_Cost + ", Navigation_Cost=" + Navigation_Cost + "]";
	}




}
