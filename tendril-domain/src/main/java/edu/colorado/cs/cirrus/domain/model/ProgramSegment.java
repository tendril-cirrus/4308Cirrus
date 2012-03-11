package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class ProgramSegment {
	@Element
	double heatingSetPoint;
	
	@Element
	double coolingSetPoint;
	
	@Element
	String timeOfDay;
	
	@Element
	String name;
	
	
	public ProgramSegment() {
		super();
	}

	public ProgramSegment(double heatingSetPoint, double coolingSetPoint,
			String timeOfDay, String name) {
		super();
		this.heatingSetPoint = heatingSetPoint;
		this.coolingSetPoint = coolingSetPoint;
		this.timeOfDay = timeOfDay;
		this.name = name;
	}

	public double getHeatingSetPoint() {
		return heatingSetPoint;
	}

	public void setHeatingSetPoint(double heatingSetPoint) {
		this.heatingSetPoint = heatingSetPoint;
	}

	public double getCoolingSetPoint() {
		return coolingSetPoint;
	}

	public void setCoolingSetPoint(double coolingSetPoint) {
		this.coolingSetPoint = coolingSetPoint;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProgramSegment [heatingSetPoint=" + heatingSetPoint
				+ ", coolingSetPoint=" + coolingSetPoint + ", timeOfDay="
				+ timeOfDay + ", name=" + name + "]";
	}
}
