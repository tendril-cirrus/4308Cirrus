package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class RelayDetail {
    
    /**
     * Constructs a new instance.
     * 
     * @param id
     *            The id for this instance.
     * @param deviceId
     *            The deviceId for this instance.
     * @param relayName
     *            The relayName for this instance.
     */
    public RelayDetail(int id, String deviceId, String relayName) {
        this.id = id;
        this.deviceId = deviceId;
        this.relayName = relayName;
    }
    
    /**
     * Constructs a new instance.
     */
    public RelayDetail() {
    }
    
    @Element
    private int id;
    
    @Element
    private String deviceId;
    
    @Element
    private String relayName;
    
    /**
     * Gets the id for this instance.
     * 
     * @return The id.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Sets the id for this instance.
     * 
     * @param id
     *            The id.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Gets the deviceId for this instance.
     * 
     * @return The deviceId.
     */
    public String getDeviceId() {
        return this.deviceId;
    }
    
    /**
     * Sets the deviceId for this instance.
     * 
     * @param deviceId
     *            The deviceId.
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    /**
     * Gets the relayName for this instance.
     * 
     * @return The relayName.
     */
    public String getRelayName() {
        return this.relayName;
    }
    
    /**
     * Sets the relayName for this instance.
     * 
     * @param relayName
     *            The relayName.
     */
    public void setRelayName(String relayName) {
        this.relayName = relayName;
    }
    
    @Override
    public String toString() {
        return "RelayDetail [id=" + id + ", deviceId=" + deviceId
                + ", relayName=" + relayName + "]";
    }
}
