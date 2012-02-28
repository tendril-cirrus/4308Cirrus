package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class DeviceData {
	@Element
	String setpoint;
	
	@Element
	String mode;
	
	@Element
	String temperatureScale;

	public DeviceData(String setpoint, String mode, String temperatureScale) {
		super();
		this.setpoint = setpoint;
		this.mode = mode;
		this.temperatureScale = temperatureScale;
	}
	
	public DeviceData() {
		super();
	}

	public String getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(String setpoint) {
		this.setpoint = setpoint;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTemperatureScale() {
		return temperatureScale;
	}

	public void setTemperatureScale(String temperatureScale) {
		this.temperatureScale = temperatureScale;
	}

	@Override
	public String toString() {
		return "DeviceData [setpoint=" + setpoint + ", mode=" + mode
				+ ", temperatureScale=" + temperatureScale + "]";
	}
	
	
}
