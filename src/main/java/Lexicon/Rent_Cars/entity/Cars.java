package Lexicon.Rent_Cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Refrance;



	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Branches branch;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Client client;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private SalesPerson salesPerson;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private RentalPrices rentalprices;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private MoreDescriptions more_Descriptions;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Agreement agreement;
	
	

	
	public Cars(String refrance) {
		super();
		Refrance = refrance;

	}

	public Cars() {}

	public String getRefrance() {
		return Refrance;
	}

	public void setRefrance(String refrance) {
		Refrance = refrance;
	}

	public Branches getBranch() {
		return branch;
	}

	public void setBranch(Branches branch) {
		this.branch = branch;
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

	public RentalPrices getRentalprices() {
		return rentalprices;
	}

	public void setRentalprices(RentalPrices rentalprices) {
		this.rentalprices = rentalprices;
	}

	public MoreDescriptions getMore_Descriptions() {
		return more_Descriptions;
	}

	public void setMore_Descriptions(MoreDescriptions more_Descriptions) {
		this.more_Descriptions = more_Descriptions;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Refrance == null) ? 0 : Refrance.hashCode());
		result = prime * result + ((agreement == null) ? 0 : agreement.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((more_Descriptions == null) ? 0 : more_Descriptions.hashCode());
		result = prime * result + ((rentalprices == null) ? 0 : rentalprices.hashCode());
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
		Cars other = (Cars) obj;
		if (ID != other.ID)
			return false;
		if (Refrance == null) {
			if (other.Refrance != null)
				return false;
		} else if (!Refrance.equals(other.Refrance))
			return false;
		if (agreement == null) {
			if (other.agreement != null)
				return false;
		} else if (!agreement.equals(other.agreement))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (more_Descriptions == null) {
			if (other.more_Descriptions != null)
				return false;
		} else if (!more_Descriptions.equals(other.more_Descriptions))
			return false;
		if (rentalprices == null) {
			if (other.rentalprices != null)
				return false;
		} else if (!rentalprices.equals(other.rentalprices))
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
		return "Cars [Refrance=" + Refrance + ", branch=" + branch + ", rentalprices=" + rentalprices
				+ ", more_Descriptions=" + more_Descriptions + "]";
	}


}
