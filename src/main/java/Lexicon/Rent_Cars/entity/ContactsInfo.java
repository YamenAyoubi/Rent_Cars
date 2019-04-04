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
public class ContactsInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String address;
	private String contactNumber;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.EAGER, 
			mappedBy = "contactsInfo", 
			orphanRemoval = true)
	private SalesPerson salesPerson;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.EAGER, 
			mappedBy = "contactsInfo", 
			orphanRemoval = true)
	private Client Client;
	
	public ContactsInfo(String address, String contactNumber) {
		super();
		this.address = address;
		this.contactNumber = contactNumber;
	}
	

	public ContactsInfo() {}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	

	public SalesPerson getSalesPerson() {
		return salesPerson;
	}


	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}


	public Client getClient() {
		return Client;
	}


	public void setClient(Client client) {
		Client = client;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Client == null) ? 0 : Client.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + id;
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
		if (Client == null) {
			if (other.Client != null)
				return false;
		} else if (!Client.equals(other.Client))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (id != other.id)
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
		return "ContactsInfo [address=" + address + ", contactNumber=" + contactNumber + "]";
	}
	
	
}
