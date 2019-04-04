package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SalesPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String secondName;



	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
	fetch = FetchType.EAGER)
	@JoinColumn(name = "ContactsInfo_ID")
	private ContactsInfo contactsInfo;

	
	
	public SalesPerson(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}


	public SalesPerson() {}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public ContactsInfo getContactsInfo() {
		return contactsInfo;
	}


	public void setContactsInfo(ContactsInfo contactsInfo) {
		this.contactsInfo = contactsInfo;
	}

	public int getId() {
		return id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactsInfo == null) ? 0 : contactsInfo.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
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
		if (contactsInfo == null) {
			if (other.contactsInfo != null)
				return false;
		} else if (!contactsInfo.equals(other.contactsInfo))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SalesPerson [firstName=" + firstName + ", secondName=" + secondName + ", contactsInfo="
				+ contactsInfo + "]";
	}
	
}

