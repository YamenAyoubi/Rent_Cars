package Lexicon.Rent_Cars.Services;

import java.util.List;
import Lexicon.Rent_Cars.entity.Payment;

public interface Payment_Service_Dao {
	
	public Payment findPaymentByID(int paymentId);

	public List<Payment> findAllPayment();

	public void cancelPayment(int paymentId);
	
	public void paymentUpdated(int paymentId, double amount);

	Payment save_Payment(Payment payment);

}
