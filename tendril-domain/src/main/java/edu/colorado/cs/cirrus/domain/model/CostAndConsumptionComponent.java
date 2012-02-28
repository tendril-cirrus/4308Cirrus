package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "component")
public class CostAndConsumptionComponent {
    
    /**
     * Constructs a new instance.
     */
    public CostAndConsumptionComponent() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param actualReadingsCount
     *            The actualReadingsCount for this instance.
     * @param toDate
     *            The toDate for this instance.
     * @param fromDate
     *            The fromDate for this instance.
     * @param peak
     *            The peak for this instance.
     * @param rateKey
     *            The rateKey for this instance.
     * @param cost
     *            The cost for this instance.
     * @param consumption
     *            The consumption for this instance.
     * @param componentList
     *            The componentList for this instance.
     */
    public CostAndConsumptionComponent(String actualReadingsCount,
            String toDate, String fromDate, String peak, String rateKey,
            float cost, float consumption,
            List<CostAndConsumptionComponent> componentList) {
        this.actualReadingsCount = actualReadingsCount;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.peak = peak;
        this.rateKey = rateKey;
        this.cost = cost;
        this.consumption = consumption;
        this.componentList = componentList;
    }
    
    @Attribute(required = false)
    private String actualReadingsCount;
    
    @Attribute(required = false)
    private String toDate;
    
    @Attribute(required = false)
    private String fromDate;
    
    @Attribute(required = false)
    private String peak;
    
    @Attribute(required = false)
    private String rateKey;
    
    @Element
    private float cost;
    
    @Element
    private float consumption;
    
    @ElementList(name = "component", required = false, inline = true)
    private List<CostAndConsumptionComponent> componentList;
    
    /**
     * Gets the actualReadingsCount for this instance.
     * 
     * @return The actualReadingsCount.
     */
    public String getActualReadingsCount() {
        return this.actualReadingsCount;
    }
    
    /**
     * Sets the actualReadingsCount for this instance.
     * 
     * @param actualReadingsCount
     *            The actualReadingsCount.
     */
    public void setActualReadingsCount(String actualReadingsCount) {
        this.actualReadingsCount = actualReadingsCount;
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
     * Gets the peak for this instance.
     * 
     * @return The peak.
     */
    public String getPeak() {
        return this.peak;
    }
    
    /**
     * Sets the peak for this instance.
     * 
     * @param peak
     *            The peak.
     */
    public void setPeak(String peak) {
        this.peak = peak;
    }
    
    /**
     * Gets the rateKey for this instance.
     * 
     * @return The rateKey.
     */
    public String getRateKey() {
        return this.rateKey;
    }
    
    /**
     * Sets the rateKey for this instance.
     * 
     * @param rateKey
     *            The rateKey.
     */
    public void setRateKey(String rateKey) {
        this.rateKey = rateKey;
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
        
        return "CostAndConsumptionComponent [actualReadingsCount="
                + actualReadingsCount + ", toDate=" + toDate + ", fromDate="
                + fromDate + ", peak=" + peak + ", rateKey=" + rateKey
                + ", cost=" + cost + ", consumption=" + consumption
                + ", componentList=" + componentList + "]";
    }
    
}
