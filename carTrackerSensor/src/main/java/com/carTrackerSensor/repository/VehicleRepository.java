package com.carTrackerSensor.repository;

import org.springframework.data.repository.CrudRepository;

import com.carTrackerSensor.model.Tires;
import com.carTrackerSensor.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, String>{

}
