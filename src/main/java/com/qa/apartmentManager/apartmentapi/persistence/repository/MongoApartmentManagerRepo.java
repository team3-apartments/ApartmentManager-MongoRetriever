package com.qa.apartmentManager.apartmentapi.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.apartmentManager.apartmentapi.persistence.domain.SentApartmentManager;

@Repository
public interface MongoApartmentManagerRepo extends MongoRepository<SentApartmentManager, Long>{
	
	public Optional<SentApartmentManager> findByApartmentId(Long apartmentId);
	
	public void deleteByApartmentId(Long apartmentId);


}
