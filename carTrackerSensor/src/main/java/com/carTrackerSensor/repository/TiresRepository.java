package com.carTrackerSensor.repository;

/**
 * @author Tej 
 *
 */
import org.springframework.data.repository.CrudRepository;

import com.carTrackerSensor.model.Tires;

public interface TiresRepository extends CrudRepository<Tires, Integer> {

}
