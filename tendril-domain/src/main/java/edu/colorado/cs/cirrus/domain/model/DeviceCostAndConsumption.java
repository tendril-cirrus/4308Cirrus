/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class DeviceCostAndConsumption {
    /**
     * Constructs a new instance.
     */
    public DeviceCostAndConsumption() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param fromDate
     *            The fromDate for this instance.
     * @param toDate
     *            The toDate for this instance.
     * @param deviceId
     *            The deviceId for this instance.
     * @param cost
     *            The cost for this instance.
     * @param consumption
     *            The consumption for this instance.
     * @param componentList
     *            The componentList for this instance.
     */
    public DeviceCostAndConsumption(String fromDate, String toDate,
            String deviceId, float cost, float consumption,
            List<CostAndConsumptionComponent> componentList) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.deviceId = deviceId;
        this.cost = cost;
        this.consumption = consumption;
        this.componentList = componentList;
    }
    
    @Attribute(required = false)
    private String fromDate;
    
    @Attribute(required = false)
    private String toDate;
    
    @Attribute
    private String deviceId;
    
    @Element
    private float cost;
    
    @Element
    private float consumption;
    
    @ElementList(required = false, inline = true)
    private List<CostAndConsumptionComponent> componentList;
    
    /**
     * Gets the fromDate for this instance.
     * 
     * @return The fromDate.
     */
    public String getFromDate() {
        return this.fromDate;
    }
    
    /**
     * Sets the fromDate for this instance.
     * 
     * @param fromDate
     *            The fromDate.
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    
    /**
     * Gets the toDate for this instance.
     * 
     * @return The toDate.
     */
    public String getToDate() {
        return this.toDate;
    }
    
    /**
     * Sets the toDate for this instance.
     * 
     * @param toDate
     *            The toDate.
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
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
     * Gets the cost for this instance.
     * 
     * @return The cost.
     */
    public float getCost() {
        return this.cost;
    }
    
    /**
     * Sets the cost for this instance.
     * 
     * @param cost
     *            The cost.
     */
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    /**
     * Gets the consumption for this instance.
     * 
     * @return The consumption.
     */
    public float getConsumption() {
        return this.consumption;
    }
    
    /**
     * Sets the consumption for this instance.
     * 
     * @param consumption
     *            The consumption.
     */
    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }
    
    /**
     * Gets the componentList for this instance.
     * 
     * @return The componentList.
     */
    public List<CostAndConsumptionComponent> getComponentList() {
        return this.componentList;
    }
    
    /**
     * Sets the componentList for this instance.
     * 
     * @param componentList
     *            The componentList.
     */
    public void setComponentList(List<CostAndConsumptionComponent> componentList) {
        this.componentList = componentList;
    }
    
    @Override
    public String toString() {
        
        return "DeviceCostAndConsumption [fromDate=" + fromDate + ", toDate="
                + toDate + ", deviceId=" + deviceId + ", cost=" + cost
                + ", consumption=" + consumption + ", componentList="
                + componentList + "]";
    }
}
