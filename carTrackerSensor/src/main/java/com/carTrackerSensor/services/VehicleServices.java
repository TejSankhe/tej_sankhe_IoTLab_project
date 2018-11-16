package com.carTrackerSensor.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carTrackerSensor.model.Vehicle;
import com.carTrackerSensor.repository.VehicleRepository;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleServices {
	@Autowired
	VehicleRepository vehicleRepository;
	@PutMapping("/vehicles")
	public String createUpdateVehicles(@RequestBody List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			Optional<Vehicle> data = vehicleRepository .findById(vehicle.getVin());
			if (data.isPresent()) {
				Vehicle newvehicle = data.get();
				vehicle.updateVehicleInfo(newvehicle);
				vehicleRepository.save(vehicle);
		}else {
			vehicleRepository.save(vehicle);
		}
			}
		return "Success";	
}
	@GetMapping("/getVehiclesDetails")
	public Iterable<Vehicle> getVehiclesDetails() {
		return vehicleRepository.findAll();
	}
}