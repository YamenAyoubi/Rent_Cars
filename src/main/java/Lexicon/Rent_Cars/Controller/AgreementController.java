package Lexicon.Rent_Cars.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Lexicon.Rent_Cars.Services.Agreement_Services_Dao;
import Lexicon.Rent_Cars.entity.Agreement;

@RestController
@RequestMapping("/myapp/api")
public class AgreementController {

	private Agreement_Services_Dao agreementService;

	@Autowired
	public AgreementController(Agreement_Services_Dao agreementService) {
		super();
		this.agreementService = agreementService;
	}
	
	@GetMapping("/allagreements")
	public ResponseEntity<List<Agreement>> get(){
		
	List<Agreement> agreements = agreementService.findAll_agreement();
	
	if(agreements.isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(agreements);
	}	
	}
}
