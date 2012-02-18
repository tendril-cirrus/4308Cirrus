package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class ProfileCategory {
    
    /**
     * Constructs a new instance.
     */
    public ProfileCategory() {
    }
    
    /**
     * Constructs a new instance.
     * 
     * @param categoryName
     *            The categoryName for this instance.
     * @param profileItemList
     *            The profileItemList for this instance.
     */
    public ProfileCategory(String categoryName,
            List<ProfileItem> profileItemList) {
        this.categoryName = categoryName;
        this.profileItemList = profileItemList;
    }
    
    @Element
    private String categoryName;
    
    @ElementList(name = "profileItemList")
    private List<ProfileItem> profileItemList;
    
    /**
     * Gets the categoryName for this instance.
     * 
     * @return The categoryName.
     */
    public String getCategoryName() {
        return this.categoryName;
    }
    
    /**
     * Sets the categoryName for this instance.
     * 
     * @param categoryName
     *            The categoryName.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    /**
     * Gets the profileItemList for this instance.
     * 
     * @return The profileItemList.
     */
    public List<ProfileItem> getProfileItemList() {
        return this.profileItemList;
    }
    
    /**
     * Sets the profileItemList for this instance.
     * 
     * @param profileItemList
     *            The profileItemList.
     */
    public void setProfileItemList(List<ProfileItem> profileItemList) {
        this.profileItemList = profileItemList;
    }
    
    @Override
    public String toString() {
        return "ProfileCategory [categoryName=" + categoryName
                + ", profileItemList=" + profileItemList.toString() + "]";
        
    }
}
