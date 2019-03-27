package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MoreDescriptions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Brand;
	private String Color;
	private String Model;
	private String Size;
	private boolean Fuel;
	private boolean Auto;
	private boolean Rented;
	private String More_Details;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;


	public MoreDescriptions(String brand, String color, String model, String size, boolean fuel, boolean auto,
			boolean rented, String more_Details) {
		super();
		Brand = brand;
		Color = color;
		Model = model;
		Size = size;
		Fuel = fuel;
		Auto = auto;
		Rented = rented;
		More_Details = more_Details;
	}
	
	public MoreDescriptions() {}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public boolean isFuel() {
		return Fuel;
	}

	public void setFuel(boolean fuel) {
		Fuel = fuel;
	}

	public boolean isAuto() {
		return Auto;
	}

	public void setAuto(boolean auto) {
		Auto = auto;
	}

	public boolean isRented() {
		return Rented;
	}

	public void setRented(boolean rented) {
		Rented = rented;
	}

	public String getMore_Details() {
		return More_Details;
	}

	public void setMore_Details(String more_Details) {
		More_Details = more_Details;
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
		result = prime * result + (Auto ? 1231 : 1237);
		result = prime * result + ((Brand == null) ? 0 : Brand.hashCode());
		result = prime * result + ((Color == null) ? 0 : Color.hashCode());
		result = prime * result + (Fuel ? 1231 : 1237);
		result = prime * result + ID;
		result = prime * result + ((Model == null) ? 0 : Model.hashCode());
		result = prime * result + ((More_Details == null) ? 0 : More_Details.hashCode());
		result = prime * result + (Rented ? 1231 : 1237);
		result = prime * result + ((Size == null) ? 0 : Size.hashCode());
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
		MoreDescriptions other = (MoreDescriptions) obj;
		if (Auto != other.Auto)
			return false;
		if (Brand == null) {
			if (other.Brand != null)
				return false;
		} else if (!Brand.equals(other.Brand))
			return false;
		if (Color == null) {
			if (other.Color != null)
				return false;
		} else if (!Color.equals(other.Color))
			return false;
		if (Fuel != other.Fuel)
			return false;
		if (ID != other.ID)
			return false;
		if (Model == null) {
			if (other.Model != null)
				return false;
		} else if (!Model.equals(other.Model))
			return false;
		if (More_Details == null) {
			if (other.More_Details != null)
				return false;
		} else if (!More_Details.equals(other.More_Details))
			return false;
		if (Rented != other.Rented)
			return false;
		if (Size == null) {
			if (other.Size != null)
				return false;
		} else if (!Size.equals(other.Size))
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
		return "MoreDescriptions [Brand=" + Brand + ", Color=" + Color + ", Model=" + Model + ", Size=" + Size
				+ ", Fuel=" + Fuel + ", Auto=" + Auto + ", Rented=" + Rented + ", More_Details=" + More_Details + "]";
	}
	
	
}
