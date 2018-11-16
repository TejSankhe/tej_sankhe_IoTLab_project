package com.carTrackerSensor.model;

/**
 * @author Tej 
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double rearLeft;

	private double rearRight;

	private double frontLeft;

	private double frontRight;

	public double getRearLeft() {
		return rearLeft;
	}

	public void setRearLeft(double rearLeft) {
		this.rearLeft = rearLeft;
	}

	public double getRearRight() {
		return rearRight;
	}

	public void setRearRight(double rearRight) {
		this.rearRight = rearRight;
	}

	public double getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(double frontLeft) {
		this.frontLeft = frontLeft;
	}

	public double getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(double frontRight) {
		this.frontRight = frontRight;
	}

}
