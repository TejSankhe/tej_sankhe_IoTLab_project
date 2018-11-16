package com.carTrackerSensor.repository;

import org.springframework.data.repository.CrudRepository;

import com.carTrackerSensor.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer>{

}
