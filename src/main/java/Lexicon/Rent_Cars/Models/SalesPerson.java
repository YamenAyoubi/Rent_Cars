package Lexicon.Rent_Cars.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SalesPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String FirstName;
	private String SecondName;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Cars cars;
	@OneToOne(cascade=CascadeType.ALL)
	private ContactsInfo contactsInfo;
	
	
	public SalesPerson(String firstName, String secondName) {
		super();
		FirstName = firstName;
		SecondName = secondName;
	
	}
	
	public SalesPerson() {}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public ContactsInfo getContactsInfo() {
		return contactsInfo;
	}

	public void setContactsInfo(ContactsInfo contactsInfo) {
		this.contactsInfo = contactsInfo;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ID;
		result = prime * result + ((SecondName == null) ? 0 : SecondName.hashCode());
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((contactsInfo == null) ? 0 : contactsInfo.hashCode());
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
		SalesPerson other = (SalesPerson) obj;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (ID != other.ID)
			return false;
		if (SecondName == null) {
			if (other.SecondName != null)
				return false;
		} else if (!SecondName.equals(other.SecondName))
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (contactsInfo == null) {
			if (other.contactsInfo != null)
				return false;
		} else if (!contactsInfo.equals(other.contactsInfo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesPerson [ID=" + ID + ", FirstName=" + FirstName + ", SecondName=" + SecondName + ", cars=" + cars
				+ ", contactsInfo=" + contactsInfo + "]";
	}
	
	
	
	
	
}

