package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class LocationProfile {
    
    /**
     * Constructs a new instance.
     */
    public LocationProfile() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param householdCategoryList
     *            The householdCategoryList for this instance.
     * @param homeDetailCategoryList
     *            The homeDetailCategoryList for this instance.
     * @param relayDetailCategoryList
     *            The relayDetailCategoryList for this instance.
     * @param profileCategoryList
     *            The profileCategoryList for this instance.
     */
    public LocationProfile(List<HouseholdCategory> householdCategoryList,
            List<HomeDetailCategory> homeDetailCategoryList,
            List<RelayDetail> relayDetailCategoryList,
            List<ProfileCategory> profileCategoryList) {
        this.householdCategoryList = householdCategoryList;
        this.homeDetailCategoryList = homeDetailCategoryList;
        this.relayDetailCategoryList = relayDetailCategoryList;
        this.profileCategoryList = profileCategoryList;
    }
    
    @ElementList(inline = true)
    private List<HouseholdCategory> householdCategoryList;
    
    @ElementList(inline = true)
    private List<HomeDetailCategory> homeDetailCategoryList;
    
    @ElementList(name = "relayDetailCategory")
    private List<RelayDetail> relayDetailCategoryList;
    
    @ElementList(name = "profileCategoryList")
    private List<ProfileCategory> profileCategoryList;
    
    /**
     * Gets the householdCategoryList for this instance.
     * 
     * @return The householdCategoryList.
     */
    public List<HouseholdCategory> getHouseholdCategoryList() {
        return this.householdCategoryList;
    }
    
    /**
     * Sets the householdCategoryList for this instance.
     * 
     * @param householdCategoryList
     *            The householdCategoryList.
     */
    public void setHouseholdCategoryList(
            List<HouseholdCategory> householdCategoryList) {
        this.householdCategoryList = householdCategoryList;
    }
    
    /**
     * Gets the homeDetailCategoryList for this instance.
     * 
     * @return The homeDetailCategoryList.
     */
    public List<HomeDetailCategory> getHomeDetailCategoryList() {
        return this.homeDetailCategoryList;
    }
    
    /**
     * Sets the homeDetailCategoryList for this instance.
     * 
     * @param homeDetailCategoryList
     *            The homeDetailCategoryList.
     */
    public void setHomeDetailCategoryList(
            List<HomeDetailCategory> homeDetailCategoryList) {
        this.homeDetailCategoryList = homeDetailCategoryList;
    }
    
    /**
     * Gets the relayDetailCategoryList for this instance.
     * 
     * @return The relayDetailCategoryList.
     */
    public List<RelayDetail> getRelayDetailCategoryList() {
        return this.relayDetailCategoryList;
    }
    
    /**
     * Sets the relayDetailCategoryList for this instance.
     * 
     * @param relayDetailCategoryList
     *            The relayDetailCategoryList.
     */
    public void setRelayDetailCategoryList(
            List<RelayDetail> relayDetailCategoryList) {
        this.relayDetailCategoryList = relayDetailCategoryList;
    }
    
    /**
     * Gets the profileCategoryList for this instance.
     * 
     * @return The profileCategoryList.
     */
    public List<ProfileCategory> getProfileCategoryList() {
        return this.profileCategoryList;
    }
    
    /**
     * Sets the profileCategoryList for this instance.
     * 
     * @param profileCategoryList
     *            The profileCategoryList.
     */
    public void setProfileCategoryList(List<ProfileCategory> profileCategoryList) {
        this.profileCategoryList = profileCategoryList;
    }
    
    @Override
    public String toString() {
        return "LocationProfile [householdCategory="
                + householdCategoryList.toString() + ", homeDetailCategory="
                + homeDetailCategoryList.toString()
                + ", relayDetailCategoryList="
                + relayDetailCategoryList.toString() + ", profileCategoryList="
                + profileCategoryList.toString() + "]";
    }
    
}
