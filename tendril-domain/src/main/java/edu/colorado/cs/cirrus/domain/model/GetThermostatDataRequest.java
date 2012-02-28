package edu.colorado.cs.cirrus.domain.model;

import java.util.Collection;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class GetThermostatDataRequest {

	public GetThermostatDataRequest() {
	}

	@Attribute
	private String deviceId;
	
	@Attribute
	private String locationId;
	
	@Attribute
	private String requestId;
	
	@Element
	private String requestState;
	
	@Element
	private String completionStatus;
	
	@Element
	private Result result;

	@Override
	public String toString() {
		return "GetThermostatDataRequest [deviceId=" + deviceId
				+ ", locationId=" + locationId + ", requestId=" + requestId
				+ ", requestState=" + requestState + ", completionStatus="
				+ completionStatus + ", result=" + result + "]";
	}
	
	
	

}
