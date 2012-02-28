package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class Data {
	public Data() {
	}

	@Element
	private String setpoint;

	@Element
	private String mode;

	@Element
	private String temperatureScale;

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
		return "Data [setpoint=" + setpoint + ", mode=" + mode
				+ ", temperatureScale=" + temperatureScale + "]";
	}

	
	
}
