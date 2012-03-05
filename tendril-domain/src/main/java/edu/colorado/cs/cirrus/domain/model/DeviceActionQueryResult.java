package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/* This is a crazy fucking class. Tendril returns a bunch of different xml structures
 * for the same type of request. This class has to deal with all of those structures.
 * DeviceActionQuery has an instance of this class (not required). This class is the one 
 * that has to deal with the different possibilities.
 * 
 * I'm planning on making all the elements optional so the deserializer won't complain
 * but then adding extra tests to make sure certain things aren't null*/

public class DeviceActionQueryResult {
	@Attribute
	String type;
	
	@Attribute(required=false)
	String networkId;//only in getVoltDataRequest
	
	@Element(required=false)//only in getVoltDataRequest
	LoadControlEvent loadControlEvent;
	
	@Element(required=false)
	double setpoint;//only in getThermostatDataRequest
	
	@Element(required=false)
	String mode;//only in getThermostatDataRequest & getVoltDataRequest
	
	@Element(required=false)
	String temperatureScale;//only in getThermostatDataRequest
	
	@Element(required=false)
	double currentTemp;//only in getThermostatDataRequest
	
	@Element(required=false)
	boolean activeLoadControlEvent;//only in getThermostatDataRequest
	
	@Element(required=false)//only in getThermostatProgramRequest
	ThermostatProgram thermostatProgram;
	
	@Element(required=false)//only in GetThermostatProgramHoldStatusRequest
	String holdStatus;
	
	
	public String getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}
	
	public ThermostatProgram getThermostatProgram() {
		return thermostatProgram;
	}

	public void setThermostatProgram(ThermostatProgram thermostatProgram) {
		this.thermostatProgram = thermostatProgram;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(double setpoint) {
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

	public double getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}

	public boolean isActiveLoadControlEvent() {
		return activeLoadControlEvent;
	}

	public void setActiveLoadControlEvent(boolean activeLoadControlEvent) {
		this.activeLoadControlEvent = activeLoadControlEvent;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public LoadControlEvent getLoadControlEvent() {
		return loadControlEvent;
	}

	public void setLoadControlEvent(LoadControlEvent loadControlEvent) {
		this.loadControlEvent = loadControlEvent;
	}
	
	
}
