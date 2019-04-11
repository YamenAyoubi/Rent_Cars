package Lexicon.Rent_Cars.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Lexicon.Rent_Cars.Services.SalesPerson_Services_Dao;
import Lexicon.Rent_Cars.entity.Client;

@RestController
@RequestMapping("/myapp/api")
public class SalesPerson_Client_Branches_Controller {

	private SalesPerson_Services_Dao service ;

	@Autowired
	public SalesPerson_Client_Branches_Controller(SalesPerson_Services_Dao service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/CreatClient")
	public ResponseEntity<Client> create_Client(@RequestBody Client newClient){
		if(newClient== null) {
			return ResponseEntity.badRequest().build();
		}
		
		Client saved = service.save_Client(newClient);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}

	@GetMapping("/allClient")
	public ResponseEntity<List<Client>> get_clients(){
		
	List<Client> allClient= service.findAll_Clients();
	
	if(allClient .isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(allClient);
	}	
	}
	
	
}
