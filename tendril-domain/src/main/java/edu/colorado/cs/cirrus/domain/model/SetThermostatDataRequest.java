package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name="setThermostatDataRequest")
@Namespace(reference="http://platform.tendrilinc.com/tnop/extension/ems")
public class SetThermostatDataRequest {
	public SetThermostatDataRequest() {
	}

	
	public SetThermostatDataRequest(String deviceId, String locationId,
			String requestId, DeviceData data) {
		super();
		this.deviceId = deviceId;
		this.locationId = locationId;
		this.requestId = requestId;
		this.data = data;
	}

	@Attribute
	private String deviceId;

	@Attribute
	private String locationId;

	@Attribute(required=false)
	private String requestId;

	@Element
	private DeviceData data;

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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public DeviceData getData() {
		return data;
	}

	public void setData(DeviceData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SetThermostatDataRequest [deviceId=" + deviceId
				+ ", locationId=" + locationId + ", requestId=" + requestId
				+ ", data=" + data + "]";
	}
	
	

}
