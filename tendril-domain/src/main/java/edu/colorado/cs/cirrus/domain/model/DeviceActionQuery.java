/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class DeviceActionQuery {
	@Attribute
	String requestId;
	
	@Attribute
	String deviceId;
	
	@Attribute
	String locationId;
	
	@Element
	String requestState;
	
	@Element
	String completionStatus;
	
	@Element(required=false)
	DeviceActionQueryResult result;
	
	public DeviceActionQuery(String requestId, String deviceId,
			String locationId, String requestState, String completionStatus, DeviceActionQueryResult result) {
		super();
		this.requestId = requestId;
		this.deviceId = deviceId;
		this.locationId = locationId;
		this.requestState = requestState;
		this.completionStatus = completionStatus;
		this.result=result;
	}
	
	public DeviceActionQuery() {
		super();
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getRequestState() {
		return requestState;
	}

	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public DeviceActionQueryResult getResult() {
		return result;
	}

	public void setResult(DeviceActionQueryResult result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "DeviceActionQuery [requestId=" + requestId + ", deviceId="
				+ deviceId + ", locationId=" + locationId + ", requestState="
				+ requestState + ", completionStatus=" + completionStatus + "]";
	}
}
