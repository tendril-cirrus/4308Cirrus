/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

//for tendril's "Create device action" call
@Root
public class DeviceAction {
	@Attribute(name="locationId")
	String locationID;
	
	@Attribute(name="requestId")
	String requestID;
	
	@Attribute(name="deviceId")
	String deviceID;
	
	@Element
	DeviceData data;

	public DeviceAction(String locationID, String requestID, String deviceID, DeviceData data) {
		super();
		this.locationID = locationID;
		this.requestID = requestID;
		this.deviceID = deviceID;
		this.data = data;
	}
	
	public DeviceAction() {
		super();
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	
	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public DeviceData getData() {
		return data;
	}

	public void setData(DeviceData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DeviceAction [locationID=" + locationID + ", requestID="
				+ requestID + ", deviceID=" + deviceID + ", data=" + data + "]";
	}
	
	
}
