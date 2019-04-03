package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String scondName;

	
	@OneToOne(cascade=CascadeType.ALL)
	private ContactsInfo contactsInfo;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Agreement agreement;
	
	public Client(String firstName, String scondName) {
		super();
		this.firstName = firstName;
		this.scondName = scondName;
	}

	public Client() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getScondName() {
		return scondName;
	}

	public void setScondName(String scondName) {
		this.scondName = scondName;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

	public int getId() {
		return id;
	}

	public ContactsInfo getContactsInfo() {
		return contactsInfo;
	}
	
	

	public void setContactsInfo(ContactsInfo contactsInfo) {
		this.contactsInfo = contactsInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreement == null) ? 0 : agreement.hashCode());
		result = prime * result + ((contactsInfo == null) ? 0 : contactsInfo.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((scondName == null) ? 0 : scondName.hashCode());
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
		Client other = (Client) obj;
		if (agreement == null) {
			if (other.agreement != null)
				return false;
		} else if (!agreement.equals(other.agreement))
			return false;
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
		if (scondName == null) {
			if (other.scondName != null)
				return false;
		} else if (!scondName.equals(other.scondName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", scondName=" + scondName + ", contactsInfo="
				+ contactsInfo + ", agreement=" + agreement + "]";
	}
	
	
	
}
