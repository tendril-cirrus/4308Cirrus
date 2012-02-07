/*
 * Insert License Here
 */

package cx.it.cirrus;

import cx.it.cirrus.util.JSONUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User {

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

    /**
     * Gets the id for this instance.
     * 
     * @return The id.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id for this instance.
     * 
     * @param id
     *            The id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the firstName for this instance.
     * 
     * @return The firstName.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName for this instance.
     * 
     * @param firstName
     *            The firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName for this instance.
     * 
     * @return The lastName.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName for this instance.
     * 
     * @param lastName
     *            The lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email for this instance.
     * 
     * @return The email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email for this instance.
     * 
     * @param email
     *            The email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the userName for this instance.
     * 
     * @return The userName.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Sets the userName for this instance.
     * 
     * @param userName
     *            The userName.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the authorId for this instance.
     * 
     * @return The authorId.
     */
    public String getAuthorId() {
        return this.authorId;
    }

    /**
     * Sets the authorId for this instance.
     * 
     * @param authorId
     *            The authorId.
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * Determines if this instance is expert.
     * 
     * @return The expert.
     */
    public boolean isExpert() {
        return this.expert;
    }

    /**
     * Sets whether or not this instance is expert.
     * 
     * @param expert
     *            The expert.
     */
    public void setExpert(boolean expert) {
        this.expert = expert;
    }

    /**
     * Determines if this instance is usingTemporaryPassword.
     * 
     * @return The usingTemporaryPassword.
     */
    public boolean isUsingTemporaryPassword() {
        return this.usingTemporaryPassword;
    }

    /**
     * Sets whether or not this instance is usingTemporaryPassword.
     * 
     * @param usingTemporaryPassword
     *            The usingTemporaryPassword.
     */
    public void setUsingTemporaryPassword(boolean usingTemporaryPassword) {
        this.usingTemporaryPassword = usingTemporaryPassword;
    }

    /**
     * Gets the object as a JSON string
     *
     * @return The json for this object
     */
    public String toJSON(){
        return JSONUtils.getObjectAsJson(this, User.class);
    }

}
