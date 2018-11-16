package com.carTrackerSensor.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carTrackerSensor.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer>{

	@Query("SELECT r FROM Reading r WHERE r.priority=:priority")
	Iterable<Reading> findByPriority(@Param("priority") String priority);
	
	@Query("SELECT r FROM Reading r WHERE r.vin=:Vin")
	Iterable<Reading> findByVin(@Param("Vin") String Vin);
}
