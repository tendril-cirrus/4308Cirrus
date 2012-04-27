package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = { "requestState", "completionStatus", "result" })
@Root
public class fetchThermostatDataRequest {

    public fetchThermostatDataRequest() {
    }

    @Attribute
    private String deviceId;

    @Attribute
    private String locationId;

    @Attribute(required = false)
    private String requestId;

    @Element(required = false)
    private String requestState;

    @Element(required = false)
    private String completionStatus;

    @Element(required = false)
    private Result result;

    @Override
    public String toString() {
        return "GetThermostatDataRequest [deviceId=" + deviceId + ", locationId=" + locationId + ", requestId="
                + requestId + ", requestState=" + requestState + ", completionStatus=" + completionStatus + ", result="
                + result + "]";
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
