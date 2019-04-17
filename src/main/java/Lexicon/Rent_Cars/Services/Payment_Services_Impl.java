package Lexicon.Rent_Cars.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lexicon.Rent_Cars.entity.Agreement;
import Lexicon.Rent_Cars.entity.Payment;
import Lexicon.Rent_Cars.repository.AgreementRepo;
import Lexicon.Rent_Cars.repository.PaymenRepo;

@Service
@Transactional
public class Payment_Services_Impl implements Payment_Service_Dao {

	private PaymenRepo payment_Repo;
	private AgreementRepo agreement_Repo;

	@Autowired
	public Payment_Services_Impl(PaymenRepo payment_Repo) {
		super();
		this.payment_Repo = payment_Repo;
	}

	@Override
	public void addPayment(Payment payment, int agreement_id) {
		Optional<Agreement> selected_agreement = agreement_Repo.findById(agreement_id);
		double remains = selected_agreement.get().getTotal_cost() - payment.getAmount();
		if (remains == 0) {
			selected_agreement.get().setPaid(true);
		} else {
			System.out.println("Remains Amount is :" + " " + remains);
			selected_agreement.get().setPaid(false);
			selected_agreement.get().getSelected_Car().getMore_Descriptions().setRented(false);
			agreement_Repo.save(selected_agreement.get());
		}
	}

	@Override
	public Payment findPaymentByID(int paymentId) {
		return payment_Repo.findById(paymentId).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public List<Payment> findAllPayment() {
		List<Payment> result = (List<Payment>) payment_Repo.findAll();
		return result;
	}

	@Override
	public void cancelPayment(int paymentId) {
		payment_Repo.deleteById(paymentId);
	}

	@Override
	public void paymentUpdated(int paymentId, double amount) {
		Optional<Payment> selected_Payment = payment_Repo.findById(paymentId);
		selected_Payment.get().setAmount(amount);
		payment_Repo.save(selected_Payment.get());
	}

}
