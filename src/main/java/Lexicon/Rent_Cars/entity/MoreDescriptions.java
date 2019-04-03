package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MoreDescriptions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String color;
	private String model;
	private String size;
	private boolean fuel;
	private boolean auto;
	private boolean rented=false;
	private String scratches;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;


	public MoreDescriptions(String brand, String color, String model, String size, boolean auto, String scratches) {
		super();
		this.brand = brand;
		this.color = color;
		this.model = model;
		this.size = size;
		this.auto = auto;
		this.scratches = scratches;
	}


	public MoreDescriptions() {}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public boolean isFuel() {
		return fuel;
	}


	public void setFuel(boolean fuel) {
		this.fuel = fuel;
	}


	public boolean isAuto() {
		return auto;
	}


	public void setAuto(boolean auto) {
		this.auto = auto;
	}


	public boolean isRented() {
		return rented;
	}


	public void setRented(boolean rented) {
		this.rented = rented;
	}


	public String getScratches() {
		return scratches;
	}


	public void setScratches(String scratches) {
		this.scratches = scratches;
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
		result = prime * result + (auto ? 1231 : 1237);
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (fuel ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (rented ? 1231 : 1237);
		result = prime * result + ((scratches == null) ? 0 : scratches.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		if (auto != other.auto)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (fuel != other.fuel)
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (rented != other.rented)
			return false;
		if (scratches == null) {
			if (other.scratches != null)
				return false;
		} else if (!scratches.equals(other.scratches))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MoreDescriptions [brand=" + brand + ", color=" + color + ", model=" + model + ", size=" + size
				+ ", fuel=" + fuel + ", auto=" + auto + ", rented=" + rented + ", scratches=" + scratches + "]";
	}
	
	
	

	
}
