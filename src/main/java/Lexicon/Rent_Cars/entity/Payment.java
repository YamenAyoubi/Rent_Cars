package Lexicon.Rent_Cars.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Lexicon.Rent_Cars.repository.AgreementRepo;


@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime paymentDateTime;
	private double amount;
	private boolean isConfirm;
	private int agreement_Id;

	public Payment(int amount, int agreement_Id) {
		super();
		this.amount = amount;
		this.agreement_Id = agreement_Id;
		this.paymentDateTime = LocalDateTime.now();
		this.isConfirm=true;
	}

	public Payment() {
		super();
	}


	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}
	
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = LocalDateTime.now();
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isConfirm() {
		return isConfirm;
	}

	public void setConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public int getAgreement_Id() {
		return agreement_Id;
	}

	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agreement_Id;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + (isConfirm ? 1231 : 1237);
		result = prime * result + ((paymentDateTime == null) ? 0 : paymentDateTime.hashCode());
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
		Payment other = (Payment) obj;
		if (agreement_Id != other.agreement_Id)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (isConfirm != other.isConfirm)
			return false;
		if (paymentDateTime == null) {
			if (other.paymentDateTime != null)
				return false;
		} else if (!paymentDateTime.equals(other.paymentDateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentDateTime=" + paymentDateTime + ", amount=" + amount + ", isConfirm="
				+ isConfirm + ", agreement_Id=" + agreement_Id + "]";
	}

}
