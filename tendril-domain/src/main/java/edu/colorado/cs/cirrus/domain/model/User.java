/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.colorado.cs.cirrus.domain.intf.IUser;
import edu.colorado.cs.cirrus.domain.util.JSONUtils;

public class User implements IUser{

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String authorId;
    private boolean expert;
    private boolean usingTemporaryPassword;

    /** Empty Constructor: Expect to Set fields manually. */
    public User() {
    }

    /**
     * Nominal Constructor for constructing a User Object.
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param userName
     * @param authorId
     * @param expert
     * @param usingTemporaryPassword
     *            ;
     */
    public User(Integer id, String firstName, String lastName, String email,
            String username, String authorId, boolean expert,
            boolean usingTemporaryPassword) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setUserName(userName);
        this.setAuthorId(authorId);
        this.setExpert(expert);
        this.setUsingTemporaryPassword(usingTemporaryPassword);
    }

    /**
     * Constructor for constructing a User Object from a JSON string
     *
     * @param json
     *
     */
    public User(String json){
        User myObject = JSONUtils.getJsonAsObject(json, User.class);
        this.setId(myObject.getId());
        this.setFirstName(myObject.getFirstName());
        this.setLastName(myObject.getLastName());
        this.setEmail(myObject.getEmail());
        this.setUserName(myObject.getUserName());
        this.setAuthorId(myObject.getAuthorId());
        this.setExpert(myObject.isExpert());
        this.setUsingTemporaryPassword(myObject.isUsingTemporaryPassword());
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getId()
	 */
    public Integer getId() {
        return this.id;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setId(java.lang.Integer)
	 */
    public void setId(Integer id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getFirstName()
	 */
    public String getFirstName() {
        return this.firstName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setFirstName(java.lang.String)
	 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getLastName()
	 */
    public String getLastName() {
        return this.lastName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setLastName(java.lang.String)
	 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getEmail()
	 */
    public String getEmail() {
        return this.email;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setEmail(java.lang.String)
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getUserName()
	 */
    public String getUserName() {
        return this.userName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setUserName(java.lang.String)
	 */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#getAuthorId()
	 */
    public String getAuthorId() {
        return this.authorId;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setAuthorId(java.lang.String)
	 */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#isExpert()
	 */
    public boolean isExpert() {
        return this.expert;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setExpert(boolean)
	 */
    public void setExpert(boolean expert) {
        this.expert = expert;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#isUsingTemporaryPassword()
	 */
    public boolean isUsingTemporaryPassword() {
        return this.usingTemporaryPassword;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#setUsingTemporaryPassword(boolean)
	 */
    public void setUsingTemporaryPassword(boolean usingTemporaryPassword) {
        this.usingTemporaryPassword = usingTemporaryPassword;
    }

    /* (non-Javadoc)
	 * @see edu.colorado.cs.cirrus.domain.IUser#toJSON()
	 */
    public String toJSON(){
        return JSONUtils.getObjectAsJson(this, User.class);
    }

	public String toJsonAsString() {
		return JSONUtils.getObjectAsJson(this, User.class);
	}

}
