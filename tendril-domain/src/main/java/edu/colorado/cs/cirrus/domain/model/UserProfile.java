package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class UserProfile{

    /**
     * Constructs a new instance.
     */
    public UserProfile()
    {
    }

    /**
     * Constructs a new instance.
     *
     * @param displayName The displayName for this instance.
     * @param aboutMe The aboutMe for this instance.
     * @param location The location for this instance.
     * @param savingsGoal The savingsGoal for this instance.
     * @param picture The picture for this instance.
     * @param makeHomeDetailPublic The makeHomeDetailPublic for this instance.
     * @param makeSavingsGoalPublic The makeSavingsGoalPublic for this instance.
     */
    public UserProfile(String displayName, String aboutMe, String location, int savingsGoal, String picture, boolean makeHomeDetailPublic, boolean makeSavingsGoalPublic)
    {
        this.displayName = displayName;
        this.aboutMe = aboutMe;
        this.location = location;
        this.savingsGoal = savingsGoal;
        this.picture = picture;
        this.makeHomeDetailPublic = makeHomeDetailPublic;
        this.makeSavingsGoalPublic = makeSavingsGoalPublic;
    }

    @Element
    private String displayName;
     
    @Element
    private String aboutMe;

    @Element
    private String location;

    @Element
    private int savingsGoal;

    @Element
    private String picture;

    @Element
    private boolean makeHomeDetailPublic;

    @Element
    private boolean makeSavingsGoalPublic;
    
    private Exception ex;//this should only be set when fetching the user profile throws an exception

    public Exception getException() {
		return ex;
	}

	public void setException(Exception ex) {
		this.ex = ex;
	}

	/**
     * Gets the displayName for this instance.
     *
     * @return The displayName.
     */
    public String getDisplayName()
    {
        return this.displayName;
    }

    /**
     * Sets the displayName for this instance.
     *
     * @param displayName The displayName.
     */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    /**
     * Gets the aboutMe for this instance.
     *
     * @return The aboutMe.
     */
    public String getAboutMe()
    {
        return this.aboutMe;
    }

    /**
     * Sets the aboutMe for this instance.
     *
     * @param aboutMe The aboutMe.
     */
    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }

    /**
     * Gets the location for this instance.
     *
     * @return The location.
     */
    public String getLocation()
    {
        return this.location;
    }

    /**
     * Sets the location for this instance.
     *
     * @param location The location.
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * Gets the savingsGoal for this instance.
     *
     * @return The savingsGoal.
     */
    public int getSavingsGoal()
    {
        return this.savingsGoal;
    }

    /**
     * Sets the savingsGoal for this instance.
     *
     * @param savingsGoal The savingsGoal.
     */
    public void setSavingsGoal(int savingsGoal)
    {
        this.savingsGoal = savingsGoal;
    }

    /**
     * Gets the picture for this instance.
     *
     * @return The picture.
     */
    public String getPicture()
    {
        return this.picture;
    }

    /**
     * Sets the picture for this instance.
     *
     * @param picture The picture.
     */
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    /**
     * Determines if this instance is makeHomeDetailPublic.
     *
     * @return The makeHomeDetailPublic.
     */
    public boolean isMakeHomeDetailPublic()
    {
        return this.makeHomeDetailPublic;
    }

    /**
     * Sets whether or not this instance is makeHomeDetailPublic.
     *
     * @param makeHomeDetailPublic The makeHomeDetailPublic.
     */
    public void setMakeHomeDetailPublic(boolean makeHomeDetailPublic)
    {
        this.makeHomeDetailPublic = makeHomeDetailPublic;
    }

    /**
     * Determines if this instance is makeSavingsGoalPublic.
     *
     * @return The makeSavingsGoalPublic.
     */
    public boolean isMakeSavingsGoalPublic()
    {
        return this.makeSavingsGoalPublic;
    }

    /**
     * Sets whether or not this instance is makeSavingsGoalPublic.
     *
     * @param makeSavingsGoalPublic The makeSavingsGoalPublic.
     */
    public void setMakeSavingsGoalPublic(boolean makeSavingsGoalPublic)
    {
        this.makeSavingsGoalPublic = makeSavingsGoalPublic;
    }

	@Override
	public String toString() {
		return "UserProfile [displayName=" + displayName + ", aboutMe="
				+ aboutMe + ", location=" + location + ", savingsGoal="
				+ savingsGoal + ", picture=" + picture
				+ ", makeHomeDetailPublic=" + makeHomeDetailPublic
				+ ", makeSavingsGoalPublic=" + makeSavingsGoalPublic + "]";
	}


}
