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
import Lexicon.Rent_Cars.entity.Branches;
import Lexicon.Rent_Cars.entity.Client;
import Lexicon.Rent_Cars.entity.ContactsInfo;
import Lexicon.Rent_Cars.entity.SalesPerson;

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
	
	@PostMapping("/CreatSalesPerson")
	public ResponseEntity<SalesPerson> create_SalesPersons(@RequestBody SalesPerson newSalesPerson){
		if(newSalesPerson== null) {
			return ResponseEntity.badRequest().build();
		}
		
		SalesPerson saved = service.Save_SalesPerson(newSalesPerson);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}

	@GetMapping("/allSalesPersons")
	public ResponseEntity<List<SalesPerson>> get_salesPersons(){
		
	List<SalesPerson> allSalesPersons= service.FindAll_SalesPerson();
	
	if(allSalesPersons.isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(allSalesPersons);
	}	
	}
	
	@PostMapping("/CreatBranch")
	public ResponseEntity<Branches> create_Branch(@RequestBody Branches newBranch){
		if(newBranch== null) {
			return ResponseEntity.badRequest().build();
		}
		
		Branches saved = service.save_Branch(newBranch);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}

	@GetMapping("/allBranches")
	public ResponseEntity<List<Branches>> get_Branches(){
		
	List<Branches> allBranches= service.findAll_Branches();
	
	if(allBranches.isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(allBranches);
	}	
	}
	
	@PostMapping("/CreatContactInfo")
	public ResponseEntity<ContactsInfo> create_Contact(@RequestBody ContactsInfo newContact){
		if(newContact== null) {
			return ResponseEntity.badRequest().build();
		}
		
		ContactsInfo saved = service.Save_Contact(newContact);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}

	@GetMapping("/allContact")
	public ResponseEntity<List<ContactsInfo>> get_Contact(){
		
	List<ContactsInfo> allContact= service.FindAll_Contact();
	
	if(allContact.isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(allContact);
	}	
	}
}
