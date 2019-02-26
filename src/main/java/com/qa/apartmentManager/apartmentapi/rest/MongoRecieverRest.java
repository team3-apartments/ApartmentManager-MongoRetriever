package com.qa.apartmentManager.apartmentapi.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.apartmentManager.apartmentapi.persistence.domain.SentApartmentManager;
import com.qa.apartmentManager.apartmentapi.persistence.repository.MongoApartmentManagerRepo;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class MongoRecieverRest {

	@Autowired
	private MongoApartmentManagerRepo repo;
	
	@GetMapping("${path.getAllData}")
	public List<SentApartmentManager> getAllData() {
		List<SentApartmentManager> f = repo.findAll();
		return f;
	}
	
	@PutMapping("${path.updateApartmentManager}")
	public void updateApartmentManager(@RequestBody SentApartmentManager apartmentmanager,
			@PathVariable Long id) {
		if (apartmentManagerExists(id)) {
			repo.deleteByApartmentId(id);
			apartmentmanager.setApartmentId(id);
			repo.save(apartmentmanager);
		}
	}

	@DeleteMapping("${path.deleteApartmentManager}")
	public void deleteApartmentManager(@PathVariable Long id) {
		if (apartmentManagerExists(id)) {
			repo.deleteByApartmentId(id);
		}
	}
	
	private boolean apartmentManagerExists(Long id) {
		Optional<SentApartmentManager> apartmentManagerOptional = repo.findByApartmentId(id);
		return apartmentManagerOptional.isPresent();
	}
}
