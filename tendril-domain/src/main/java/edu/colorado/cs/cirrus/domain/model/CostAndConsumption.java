/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class CostAndConsumption {
    public static final String RANGE = "RANGE";
    public static final String HOURLY = "HOURLY";
    public static final String DAILY = "DAILY";
    public static final String MONTHLY = "MONTHLY";
    private static final List<String> resolutions = new ArrayList<String>();
    
    static{
        resolutions.add(RANGE);
        resolutions.add(HOURLY);
        resolutions.add(DAILY);
        resolutions.add(MONTHLY);
    }
   
    public static List<String> getResolutions(){
        return resolutions;
    }
    
    /**
     * Constructs a new instance.
     */
    public CostAndConsumption() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param accountId
     *            The accountId for this instance.
     * @param toDate
     *            The toDate for this instance.
     * @param fromDate
     *            The fromDate for this instance.
     * @param cost
     *            The cost for this instance.
     * @param consumption
     *            The consumption for this instance.
     * @param conversionFactorList
     *            The conversionFactorList for this instance.
     * @param componentList
     *            The componentList for this instance.
     * @param deviceCostAndConsumptionList
     *            The deviceCostAndConsumptionList for this instance.
     */
    public CostAndConsumption(String accountId, String toDate, String fromDate,
            float cost, float consumption,
            List<ConversionFactor> conversionFactorList,
            List<CostAndConsumptionComponent> componentList,
            List<DeviceCostAndConsumption> deviceCostAndConsumptionList) {
        this.accountId = accountId;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.cost = cost;
        this.consumption = consumption;
        this.conversionFactorList = conversionFactorList;
        this.componentList = componentList;
        this.deviceCostAndConsumptionList = deviceCostAndConsumptionList;
    }
    
    @Attribute
    private String accountId;
    
    @Attribute
    private String toDate;
    
    @Attribute
    private String fromDate;
    
    @Element
    private float cost;
    
    @Element
    private float consumption;
    
    @ElementList(required=false)
    private List<ConversionFactor> conversionFactorList;
    
    @ElementList(name = "component", inline = true, required=false)
    private List<CostAndConsumptionComponent> componentList;
    
    @ElementList(name = "subMeteringDetails",required=false)
    private List<DeviceCostAndConsumption> deviceCostAndConsumptionList;
    
    /**
     * Gets the accountId for this instance.
     * 
     * @return The accountId.
     */
    public String getAccountId() {
        return this.accountId;
    }
    
    /**
     * Sets the accountId for this instance.
     * 
     * @param accountId
     *            The accountId.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
     * Gets the conversionFactorList for this instance.
     * 
     * @return The conversionFactorList.
     */
    public List<ConversionFactor> getConversionFactorList() {
        return this.conversionFactorList;
    }
    
    /**
     * Sets the conversionFactorList for this instance.
     * 
     * @param conversionFactorList
     *            The conversionFactorList.
     */
    public void setConversionFactorList(
            List<ConversionFactor> conversionFactorList) {
        this.conversionFactorList = conversionFactorList;
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
    
    /**
     * Gets the deviceCostAndConsumptionList for this instance.
     * 
     * @return The deviceCostAndConsumptionList.
     */
    public List<DeviceCostAndConsumption> getDeviceCostAndConsumptionList() {
        return this.deviceCostAndConsumptionList;
    }
    
    /**
     * Sets the deviceCostAndConsumptionList for this instance.
     * 
     * @param deviceCostAndConsumptionList
     *            The deviceCostAndConsumptionList.
     */
    public void setDeviceCostAndConsumptionList(
            List<DeviceCostAndConsumption> deviceCostAndConsumptionList) {
        this.deviceCostAndConsumptionList = deviceCostAndConsumptionList;
    }
    
    @Override
    public String toString() {
        
        return "CostAndConsumption [accountId=" + accountId + ", toDate="
                + toDate + ", fromDate=" + fromDate + ", cost=" + cost
                + ", consumption=" + consumption + ", conversionFactorList="
                + conversionFactorList + ", componentList=" + componentList
                + ", deviceCostAndConsumptionList="
                + deviceCostAndConsumptionList + "]";
        
    }
    
}
