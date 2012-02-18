package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class HouseholdCategory {
    
    /**
     * Constructs a new instance.
     */
    public HouseholdCategory() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param numPeopleInAgeGroup1
     *            The numPeopleInAgeGroup1 for this instance.
     * @param numPeopleInAgeGroup2
     *            The numPeopleInAgeGroup2 for this instance.
     * @param numPeopleInAgeGroup3
     *            The numPeopleInAgeGroup3 for this instance.
     * @param numPeopleInAgeGroup4
     *            The numPeopleInAgeGroup4 for this instance.
     * @param stayHomeOnWeekdays
     *            The stayHomeOnWeekdays for this instance.
     * @param occupations
     *            The occupations for this instance.
     */
    public HouseholdCategory(int numPeopleInAgeGroup1,
            int numPeopleInAgeGroup2, int numPeopleInAgeGroup3,
            int numPeopleInAgeGroup4, boolean stayHomeOnWeekdays,
            String occupations) {
        this.numPeopleInAgeGroup1 = numPeopleInAgeGroup1;
        this.numPeopleInAgeGroup2 = numPeopleInAgeGroup2;
        this.numPeopleInAgeGroup3 = numPeopleInAgeGroup3;
        this.numPeopleInAgeGroup4 = numPeopleInAgeGroup4;
        this.stayHomeOnWeekdays = stayHomeOnWeekdays;
        this.occupations = occupations;
    }
    
    @Element
    private int numPeopleInAgeGroup1;
    
    @Element
    private int numPeopleInAgeGroup2;
    
    @Element
    private int numPeopleInAgeGroup3;
    
    @Element
    private int numPeopleInAgeGroup4;
    
    @Element
    private boolean stayHomeOnWeekdays;
    
    @Element(required = false)
    private String occupations;
    
    /**
     * Gets the numPeopleInAgeGroup1 for this instance.
     * 
     * @return The numPeopleInAgeGroup1.
     */
    public int getNumPeopleInAgeGroup1() {
        return this.numPeopleInAgeGroup1;
    }
    
    /**
     * Sets the numPeopleInAgeGroup1 for this instance.
     * 
     * @param numPeopleInAgeGroup1
     *            The numPeopleInAgeGroup1.
     */
    public void setNumPeopleInAgeGroup1(int numPeopleInAgeGroup1) {
        this.numPeopleInAgeGroup1 = numPeopleInAgeGroup1;
    }
    
    /**
     * Gets the numPeopleInAgeGroup2 for this instance.
     * 
     * @return The numPeopleInAgeGroup2.
     */
    public int getNumPeopleInAgeGroup2() {
        return this.numPeopleInAgeGroup2;
    }
    
    /**
     * Sets the numPeopleInAgeGroup2 for this instance.
     * 
     * @param numPeopleInAgeGroup2
     *            The numPeopleInAgeGroup2.
     */
    public void setNumPeopleInAgeGroup2(int numPeopleInAgeGroup2) {
        this.numPeopleInAgeGroup2 = numPeopleInAgeGroup2;
    }
    
    /**
     * Gets the numPeopleInAgeGroup3 for this instance.
     * 
     * @return The numPeopleInAgeGroup3.
     */
    public int getNumPeopleInAgeGroup3() {
        return this.numPeopleInAgeGroup3;
    }
    
    /**
     * Sets the numPeopleInAgeGroup3 for this instance.
     * 
     * @param numPeopleInAgeGroup3
     *            The numPeopleInAgeGroup3.
     */
    public void setNumPeopleInAgeGroup3(int numPeopleInAgeGroup3) {
        this.numPeopleInAgeGroup3 = numPeopleInAgeGroup3;
    }
    
    /**
     * Gets the numPeopleInAgeGroup4 for this instance.
     * 
     * @return The numPeopleInAgeGroup4.
     */
    public int getNumPeopleInAgeGroup4() {
        return this.numPeopleInAgeGroup4;
    }
    
    /**
     * Sets the numPeopleInAgeGroup4 for this instance.
     * 
     * @param numPeopleInAgeGroup4
     *            The numPeopleInAgeGroup4.
     */
    public void setNumPeopleInAgeGroup4(int numPeopleInAgeGroup4) {
        this.numPeopleInAgeGroup4 = numPeopleInAgeGroup4;
    }
    
    /**
     * Determines if this instance is stayHomeOnWeekdays.
     * 
     * @return The stayHomeOnWeekdays.
     */
    public boolean isStayHomeOnWeekdays() {
        return this.stayHomeOnWeekdays;
    }
    
    /**
     * Sets whether or not this instance is stayHomeOnWeekdays.
     * 
     * @param stayHomeOnWeekdays
     *            The stayHomeOnWeekdays.
     */
    public void setStayHomeOnWeekdays(boolean stayHomeOnWeekdays) {
        this.stayHomeOnWeekdays = stayHomeOnWeekdays;
    }
    
    /**
     * Gets the occupations for this instance.
     * 
     * @return The occupations.
     */
    public String getOccupations() {
        return this.occupations;
    }
    
    /**
     * Sets the occupations for this instance.
     * 
     * @param occupations
     *            The occupations.
     */
    public void setOccupations(String occupations) {
        this.occupations = occupations;
    }
    
    @Override
    public String toString() {
        return "HouseholdCategory [numPeopleInAgeGroup1="
                + numPeopleInAgeGroup1 + ", numPeopleInAgeGroup2="
                + numPeopleInAgeGroup2 + ", numPeopleInAgeGroup3="
                + numPeopleInAgeGroup3 + ", numPeopleInAgeGroup4="
                + numPeopleInAgeGroup4 + ", stayHomeOnWeekdays="
                + stayHomeOnWeekdays + ", occupations=" + occupations + "]";
    }
    
}
