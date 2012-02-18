package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class HomeDetailCategory {
    
    /**
     * Constructs a new instance.
     */
    public HomeDetailCategory() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param dwellingType
     *            The dwellingType for this instance.
     * @param yearBuilt
     *            The yearBuilt for this instance.
     * @param dwellingSize
     *            The dwellingSize for this instance.
     * @param hvacCoolingConfig
     *            The hvacCoolingConfig for this instance.
     * @param hvacHeatingConfig
     *            The hvacHeatingConfig for this instance.
     * @param waterHeaterType
     *            The waterHeaterType for this instance.
     * @param poolPump
     *            The poolPump for this instance.
     * @param hotTub
     *            The hotTub for this instance.
     * @param rented
     *            The rented for this instance.
     */
    public HomeDetailCategory(String dwellingType, String yearBuilt,
            String dwellingSize, String hvacCoolingConfig,
            String hvacHeatingConfig, String waterHeaterType, boolean poolPump,
            boolean hotTub, boolean rented) {
        this.dwellingType = dwellingType;
        this.yearBuilt = yearBuilt;
        this.dwellingSize = dwellingSize;
        this.hvacCoolingConfig = hvacCoolingConfig;
        this.waterHeaterType = waterHeaterType;
        this.poolPump = poolPump;
        this.hotTub = hotTub;
        this.rented = rented;
    }
    
    @Element
    private String dwellingType;
    
    @Element
    private String yearBuilt;
    
    @Element
    private String dwellingSize;
    
    @Element
    private String hvacCoolingConfig;
    
    @Element
    private String hvacHeatingConfig;
    
    @Element
    private String waterHeaterType;
    
    @Element
    private boolean poolPump;
    
    @Element
    private boolean hotTub;
    
    @Element
    private boolean rented;
    
    /**
     * Gets the dwellingType for this instance.
     * 
     * @return The dwellingType.
     */
    public String getDwellingType() {
        return this.dwellingType;
    }
    
    /**
     * Sets the dwellingType for this instance.
     * 
     * @param dwellingType
     *            The dwellingType.
     */
    public void setDwellingType(String dwellingType) {
        this.dwellingType = dwellingType;
    }
    
    /**
     * Gets the yearBuilt for this instance.
     * 
     * @return The yearBuilt.
     */
    public String getYearBuilt() {
        return this.yearBuilt;
    }
    
    /**
     * Sets the yearBuilt for this instance.
     * 
     * @param yearBuilt
     *            The yearBuilt.
     */
    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    /**
     * Gets the dwellingSize for this instance.
     * 
     * @return The dwellingSize.
     */
    public String getDwellingSize() {
        return this.dwellingSize;
    }
    
    /**
     * Sets the dwellingSize for this instance.
     * 
     * @param dwellingSize
     *            The dwellingSize.
     */
    public void setDwellingSize(String dwellingSize) {
        this.dwellingSize = dwellingSize;
    }
    
    /**
     * Gets the hvacCoolingConfig for this instance.
     * 
     * @return The hvacCoolingConfig.
     */
    public String getHvacCoolingConfig() {
        return this.hvacCoolingConfig;
    }
    
    /**
     * Sets the hvacCoolingConfig for this instance.
     * 
     * @param hvacCoolingConfig
     *            The hvacCoolingConfig.
     */
    public void setHvacCoolingConfig(String hvacCoolingConfig) {
        this.hvacCoolingConfig = hvacCoolingConfig;
    }
    
    /**
     * Gets the hvacHeatingConfig for this instance.
     * 
     * @return The hvacHeatingConfig.
     */
    public String getHvacHeatingConfig() {
        return this.hvacHeatingConfig;
    }
    
    /**
     * Sets the hvacHeatingConfig for this instance.
     * 
     * @param hvacHeatingConfig
     *            The hvacHeatingConfig.
     */
    public void setHvacHeatingConfig(String hvacHeatingConfig) {
        this.hvacHeatingConfig = hvacHeatingConfig;
    }
    
    /**
     * Gets the waterHeaterType for this instance.
     * 
     * @return The waterHeaterType.
     */
    public String getWaterHeaterType() {
        return this.waterHeaterType;
    }
    
    /**
     * Sets the waterHeaterType for this instance.
     * 
     * @param waterHeaterType
     *            The waterHeaterType.
     */
    public void setWaterHeaterType(String waterHeaterType) {
        this.waterHeaterType = waterHeaterType;
    }
    
    /**
     * Determines if this instance is poolPump.
     * 
     * @return The poolPump.
     */
    public boolean isPoolPump() {
        return this.poolPump;
    }
    
    /**
     * Sets whether or not this instance is poolPump.
     * 
     * @param poolPump
     *            The poolPump.
     */
    public void setPoolPump(boolean poolPump) {
        this.poolPump = poolPump;
    }
    
    /**
     * Determines if this instance is hotTub.
     * 
     * @return The hotTub.
     */
    public boolean isHotTub() {
        return this.hotTub;
    }
    
    /**
     * Sets whether or not this instance is hotTub.
     * 
     * @param hotTub
     *            The hotTub.
     */
    public void setHotTub(boolean hotTub) {
        this.hotTub = hotTub;
    }
    
    /**
     * Determines if this instance is rented.
     * 
     * @return The rented.
     */
    public boolean isRented() {
        return this.rented;
    }
    
    /**
     * Sets whether or not this instance is rented.
     * 
     * @param rented
     *            The rented.
     */
    public void setRented(boolean rented) {
        this.rented = rented;
    }
    
    @Override
    public String toString() {
        return "HomeDetailCategory [dwellingType=" + dwellingType
                + ", yearBuilt=" + yearBuilt + ", dwellingSize=" + dwellingSize
                + ", hvacCoolingConfig=" + hvacCoolingConfig
                + ", hvacHeatingConfig=" + hvacHeatingConfig
                + ", waterHeaterType=" + waterHeaterType + ", poolPump="
                + poolPump + ", hotTub=" + hotTub + ", rented=" + rented + "]";
    }
    
}
