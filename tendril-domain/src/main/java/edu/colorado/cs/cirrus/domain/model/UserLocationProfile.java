/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import java.util.ArrayList;

import edu.colorado.cs.cirrus.domain.util.JSONUtils;


public class UserLocationProfile {

    public Integer numPeopleInAgeGroup1;
    public Integer numPeopleInAgeGroup2;
    public Integer numPeopleInAgeGroup3;
    public Integer numPeopleInAgeGroup4;
    public boolean stayHomeOnWeekends;
    // TODO determine if occupations will be an array
    // as of 2/6/12 no example accounts have this set
    public ArrayList<String> occupations;

    /**
     * Constructs a new instance.
     */
    public UserLocationProfile() {
    }

    
    /**
     * Nominal Constructor
     * 
     * @param numPeopleInAgeGroup1
     * @param numPeopleInAgeGroup2
     * @param numPeopleInAgeGroup3
     * @param numPeopleInAgeGroup4
     * @param stayHomeOnWeekends
     * @param occupations
     */
    public UserLocationProfile(Integer numPeopleInAgeGroup1,
                               Integer numPeopleInAgeGroup2,
                               Integer numPeopleInAgeGroup3,
                               Integer numPeopleInAgeGroup4,
                               boolean stayHomeOnWeekends,
                               ArrayList<String> occupations){

        this.setNumPeopleInAgeGroup1(numPeopleInAgeGroup1);
        this.setNumPeopleInAgeGroup2(numPeopleInAgeGroup2);
        this.setNumPeopleInAgeGroup3(numPeopleInAgeGroup3);
        this.setNumPeopleInAgeGroup4(numPeopleInAgeGroup4);
        this.setStayHomeOnWeekends(stayHomeOnWeekends);
        this.setOccupations(occupations);
    }

    /**
     * Constructor for constructing a User Object from a JSON string
     * 
     * @param json
     */
    public UserLocationProfile(String json){
        UserLocationProfile myULP = JSONUtils.getJsonAsObject(json,
                                        UserLocationProfile.class);

        this.setNumPeopleInAgeGroup1(myULP.getNumPeopleInAgeGroup1());
        this.setNumPeopleInAgeGroup2(myULP.getNumPeopleInAgeGroup2());
        this.setNumPeopleInAgeGroup3(myULP.getNumPeopleInAgeGroup3());
        this.setNumPeopleInAgeGroup4(myULP.getNumPeopleInAgeGroup4());
        this.setStayHomeOnWeekends(myULP.isStayHomeOnWeekends());
        this.setOccupations(myULP.getOccupations());

    }

    /**
     * Gets the numPeopleInAgeGroup1 for this instance.
     * 
     * @return The numPeopleInAgeGroup1.
     */
    public Integer getNumPeopleInAgeGroup1() {
        return this.numPeopleInAgeGroup1;
    }

    /**
     * Sets the numPeopleInAgeGroup1 for this instance.
     * 
     * @param numPeopleInAgeGroup1
     *            The numPeopleInAgeGroup1.
     */
    public void setNumPeopleInAgeGroup1(Integer numPeopleInAgeGroup1) {
        this.numPeopleInAgeGroup1 = numPeopleInAgeGroup1;
    }

    /**
     * Gets the numPeopleInAgeGroup2 for this instance.
     * 
     * @return The numPeopleInAgeGroup2.
     */
    public Integer getNumPeopleInAgeGroup2() {
        return this.numPeopleInAgeGroup2;
    }

    /**
     * Sets the numPeopleInAgeGroup2 for this instance.
     * 
     * @param numPeopleInAgeGroup2
     *            The numPeopleInAgeGroup2.
     */
    public void setNumPeopleInAgeGroup2(Integer numPeopleInAgeGroup2) {
        this.numPeopleInAgeGroup2 = numPeopleInAgeGroup2;
    }

    /**
     * Gets the numPeopleInAgeGroup3 for this instance.
     * 
     * @return The numPeopleInAgeGroup3.
     */
    public Integer getNumPeopleInAgeGroup3() {
        return this.numPeopleInAgeGroup3;
    }

    /**
     * Sets the numPeopleInAgeGroup3 for this instance.
     * 
     * @param numPeopleInAgeGroup3
     *            The numPeopleInAgeGroup3.
     */
    public void setNumPeopleInAgeGroup3(Integer numPeopleInAgeGroup3) {
        this.numPeopleInAgeGroup3 = numPeopleInAgeGroup3;
    }

    /**
     * Gets the numPeopleInAgeGroup4 for this instance.
     * 
     * @return The numPeopleInAgeGroup4.
     */
    public Integer getNumPeopleInAgeGroup4() {
        return this.numPeopleInAgeGroup4;
    }

    /**
     * Sets the numPeopleInAgeGroup4 for this instance.
     * 
     * @param numPeopleInAgeGroup4
     *            The numPeopleInAgeGroup4.
     */
    public void setNumPeopleInAgeGroup4(Integer numPeopleInAgeGroup4) {
        this.numPeopleInAgeGroup4 = numPeopleInAgeGroup4;
    }

    /**
     * Determines if this instance is stayHomeOnWeekends.
     * 
     * @return The stayHomeOnWeekends.
     */
    public boolean isStayHomeOnWeekends() {
        return this.stayHomeOnWeekends;
    }

    /**
     * Sets whether or not this instance is stayHomeOnWeekends.
     * 
     * @param stayHomeOnWeekends
     *            The stayHomeOnWeekends.
     */
    public void setStayHomeOnWeekends(boolean stayHomeOnWeekends) {
        this.stayHomeOnWeekends = stayHomeOnWeekends;
    }

    /**
     * Gets the occupations for this instance.
     * 
     * @return The occupations.
     */
    public ArrayList<String> getOccupations() {
        return this.occupations;
    }

    /**
     * Sets the occupations for this instance.
     * 
     * @param occupations
     *            The occupations.
     */
    public void setOccupations(ArrayList<String> occupations) {
        this.occupations = occupations;
    }

    /**
     * Gets the object as a JSON string
     * 
     * @return The json for this object
     */
    public String toJSON() {
        return JSONUtils.getObjectAsJson(this, UserLocationProfile.class);
    }


}
