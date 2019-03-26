package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ContactsInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Address;
	private String ContactNumber;

	@OneToOne(cascade=CascadeType.ALL)
	private Client client;
	@OneToOne(cascade=CascadeType.ALL)
	private SalesPerson salesPerson;
	
	public ContactsInfo(String address, String contactNumber) {
		super();
		Address = address;
		ContactNumber = contactNumber;
	}
	
	public ContactsInfo() {}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SalesPerson getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((ContactNumber == null) ? 0 : ContactNumber.hashCode());
		result = prime * result + ID;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((salesPerson == null) ? 0 : salesPerson.hashCode());
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
		ContactsInfo other = (ContactsInfo) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (ContactNumber == null) {
			if (other.ContactNumber != null)
				return false;
		} else if (!ContactNumber.equals(other.ContactNumber))
			return false;
		if (ID != other.ID)
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (salesPerson == null) {
			if (other.salesPerson != null)
				return false;
		} else if (!salesPerson.equals(other.salesPerson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactsInfo [ID=" + ID + ", Address=" + Address + ", ContactNumber=" + ContactNumber + ", client="
				+ client + ", salesPerson=" + salesPerson + "]";
	}
	
	
	
}
