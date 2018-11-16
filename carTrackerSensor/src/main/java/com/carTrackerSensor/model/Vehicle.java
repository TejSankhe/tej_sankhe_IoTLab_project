package com.carTrackerSensor.model;

/**
 * @author Tej 
 *
 */
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Vehicle")
public class Vehicle {
	@Id
	@Column(name = "vin", nullable = false)
	private String vin;
	private String make;
	private String model;
	private int year;
	private double redlineRpm;
	private double maxFuelVolume;
	private Timestamp lastServiceDate;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(double redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public double getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(double maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public Timestamp getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Timestamp lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	/**
	 * Updating vehicle details which is already present in database.
	 * @param vehicle
	 */
	public void updateVehicleInfo(Vehicle vehicle) {
		String updatedmake = vehicle.getMake() != null ? vehicle.getMake() : this.getMake();
		this.setMake(updatedmake);
		String updatemodel = vehicle.getModel() != null ? vehicle.getModel() : this.getModel();
		this.setModel(updatemodel);
		this.setYear(vehicle.getYear());
		this.setRedlineRpm(vehicle.getRedlineRpm());
		this.setMaxFuelVolume(vehicle.getMaxFuelVolume());
		/*
		 * int updatedyear = vehicle.getYear()!=null? vehicle.getYear():this.getYear();
		 * this.setYear(updatedyear); String updatedRedlineRpm =
		 * vehicle.getRedlineRpm()!=null? vehicle.getRedlineRpm():this.getRedlineRpm();
		 * this.setRedlineRpm(updatedRedlineRpm); String updatedMaxFuelVolume =
		 * vehicle.getMaxFuelVolume()!=null?
		 * vehicle.getMaxFuelVolume():this.getMaxFuelVolume();
		 * this.setMaxFuelVolume(updatedMaxFuelVolume);
		 */
		Timestamp updatedLastServiceDate = vehicle.getLastServiceDate() != null ? vehicle.getLastServiceDate()
				: this.getLastServiceDate();
		this.setLastServiceDate(updatedLastServiceDate);
	}
}
