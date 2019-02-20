package com.qa.apartmentManager.apartmentapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		return repo.findAll();
	}
}
