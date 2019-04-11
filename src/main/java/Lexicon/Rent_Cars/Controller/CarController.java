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

import Lexicon.Rent_Cars.Services.Cars_Services_Dao;
import Lexicon.Rent_Cars.entity.Cars;
import Lexicon.Rent_Cars.entity.MoreDescriptions;

@RestController
@RequestMapping("/myapp/api")
public class CarController {
	
	private Cars_Services_Dao car_Service;

	@Autowired
	public CarController(Cars_Services_Dao car_Service) {
		super();
		this.car_Service = car_Service;
	}
	
	@PostMapping("/CreatCar")
	public ResponseEntity<Cars> create(@RequestBody Cars newCar){
		if(newCar== null) {
			return ResponseEntity.badRequest().build();
		}
		
		Cars saved = car_Service.save_Car(newCar);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}

	@GetMapping("/allMoreDes")
	public ResponseEntity<List<MoreDescriptions>> get(){
		
	List<MoreDescriptions> moreDes = car_Service.findAll__moreDes();
	
	if(moreDes .isEmpty()) {
		return ResponseEntity.noContent().build();
	}else {
		return ResponseEntity.ok(moreDes );
	}	
	}
	
	@PostMapping("/CreatMoreDes")
	public ResponseEntity<MoreDescriptions> create(@RequestBody MoreDescriptions MoreDes){
		if(MoreDes== null) {
			return ResponseEntity.badRequest().build();
		}
		
		MoreDescriptions saved = car_Service.Save_More_Des(MoreDes);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);		
	}
	
}
