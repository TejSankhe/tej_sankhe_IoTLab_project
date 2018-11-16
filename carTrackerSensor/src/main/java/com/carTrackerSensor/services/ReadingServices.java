package com.carTrackerSensor.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carTrackerSensor.common.Constants;
import com.carTrackerSensor.model.Reading;
import com.carTrackerSensor.model.Tires;
import com.carTrackerSensor.model.Vehicle;
import com.carTrackerSensor.repository.ReadingRepository;
import com.carTrackerSensor.repository.TiresRepository;
import com.carTrackerSensor.repository.VehicleRepository;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReadingServices {
	@Autowired
	ReadingRepository readingRepository;
	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	TiresRepository  tiresRepository;
	@PostMapping("/readings")
	public void createUpdateVehicles(@RequestBody Reading reading){
		Tires tires = reading.getTires();
		if(tires.getFrontRight()<32 || tires.getFrontRight()>36) {
			reading.setPriority(Constants.prorityLow);
		}else if(tires.getFrontLeft()<32 || tires.getFrontLeft()>36) {
			reading.setPriority(Constants.prorityLow);
		}else if(tires.getRearLeft()<32 || tires.getRearLeft()>36) {
			reading.setPriority(Constants.prorityLow);
		}else if(tires.getRearRight()<32 || tires.getRearRight()>36) {
			reading.setPriority(Constants.prorityLow);
		}
		Optional<Vehicle> data = vehicleRepository .findById(reading.getVin());
		if (data.isPresent()) {
			Vehicle vehicle = data.get();
			if(reading.getEngineRpm() > vehicle.getRedlineRpm()) {
				reading.setPriority(Constants.prorityHigh);
			}else if(reading.getFuelVolume()<0.1*vehicle.getMaxFuelVolume()){
				reading.setPriority(Constants.prorityMedium);
			}
		}
		    
		readingRepository.save(reading);
}
	
	@GetMapping("/getHighAlerts")
	public Iterable<Reading> getHighAlerts() {
		List<Vehicle> vehiclesHighPiority= new ArrayList();
		Iterable<Reading>  readings = readingRepository.findByPriority(Constants.prorityHigh);
		for(Reading reading : readings) {
			Timestamp currentTime= new Timestamp(System.currentTimeMillis());
	        Calendar c=Calendar.getInstance();
	        c.add(Calendar.HOUR, -2);
	        Timestamp timebeforetwohours= new Timestamp(c.getTimeInMillis());
	        Timestamp readingTime = reading.getTimestamp();
	        if(readingTime.after(timebeforetwohours) && readingTime.before(currentTime) )
	        {
	        	Optional<Vehicle> data = vehicleRepository .findById(reading.getVin());
	    		if (data.isPresent()) {
	    			Vehicle vehicle = data.get();
	        	vehiclesHighPiority.add(vehicle); 
	    		}
	        }
	       
		}
		return readings;
		
	}
	
	@GetMapping("/vehicleHistoricalAlerts/{vin}")
	public Iterable<Reading> getvehicleHistoricalAlerts(@PathVariable("vin") String vin) {
		Iterable<Reading> readings = readingRepository.findByVin(vin);
		return readings;
	}

}