package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class ConversionFactor {
    
    /**
     * Constructs a new instance.
     * 
     * @param unitName
     *            The unitName for this instance.
     * @param factor
     *            The factor for this instance.
     */
    public ConversionFactor(String unitName, float factor) {
        this.unitName = unitName;
        this.factor = factor;
    }
    
    /**
     * Constructs a new instance.
     */
    public ConversionFactor() {
    }
    
    @Element
    private String unitName;
    
    @Element
    private float factor;
    
    /**
     * Gets the unitName for this instance.
     * 
     * @return The unitName.
     */
    public String getUnitName() {
        return this.unitName;
    }
    
    /**
     * Sets the unitName for this instance.
     * 
     * @param unitName
     *            The unitName.
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    /**
     * Gets the factor for this instance.
     * 
     * @return The factor.
     */
    public float getFactor() {
        return this.factor;
    }
    
    /**
     * Sets the factor for this instance.
     * 
     * @param factor
     *            The factor.
     */
    public void setFactor(float factor) {
        this.factor = factor;
    }
    
    @Override
    public String toString() {
        
        return "ConversionFactor [unitName=" + unitName + ", factor=" + factor
                + "]";
    }
    
}
