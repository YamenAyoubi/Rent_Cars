package Lexicon.Rent_Cars.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Lexicon.Rent_Cars.Services.Payment_Service_Dao;
import Lexicon.Rent_Cars.entity.Payment;

@RestController
@RequestMapping("/myapp/api")
public class Payment_Controller {

	private Payment_Service_Dao payment_Service;

	@Autowired
	public Payment_Controller(Payment_Service_Dao payment_Service) {
		super();
		this.payment_Service = payment_Service;
	}
	
	@GetMapping("/allPayments")
	public ResponseEntity<List<Payment>> getAllPayments() {

		List<Payment> payments = payment_Service.findAllPayment();

		if (payments.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(payments);
		}
	}

	@PostMapping("/CreatPayment")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment newPayment) {
		if (newPayment == null) {
			return ResponseEntity.badRequest().build();
		}

		Payment saved = payment_Service.save_Payment(newPayment);

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping("/allPayments/{id}")
	public ResponseEntity<Payment> Payment_By_Id(@PathVariable int id) {
		try {
			return ResponseEntity.ok(payment_Service.findPaymentByID(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
