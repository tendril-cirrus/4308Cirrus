package edu.colorado.cs.cirrus.domain.intf;

public interface IUser extends ITendrilObject{

	/**
	 * Gets the id for this instance.
	 * 
	 * @return The id.
	 */
	public abstract Integer getId();

	/**
	 * Sets the id for this instance.
	 * 
	 * @param id
	 *            The id.
	 */
	public abstract void setId(Integer id);

	/**
	 * Gets the firstName for this instance.
	 * 
	 * @return The firstName.
	 */
	public abstract String getFirstName();

	/**
	 * Sets the firstName for this instance.
	 * 
	 * @param firstName
	 *            The firstName.
	 */
	public abstract void setFirstName(String firstName);

	/**
	 * Gets the lastName for this instance.
	 * 
	 * @return The lastName.
	 */
	public abstract String getLastName();

	/**
	 * Sets the lastName for this instance.
	 * 
	 * @param lastName
	 *            The lastName.
	 */
	public abstract void setLastName(String lastName);

	/**
	 * Gets the email for this instance.
	 * 
	 * @return The email.
	 */
	public abstract String getEmail();

	/**
	 * Sets the email for this instance.
	 * 
	 * @param email
	 *            The email.
	 */
	public abstract void setEmail(String email);

	/**
	 * Gets the userName for this instance.
	 * 
	 * @return The userName.
	 */
	public abstract String getUserName();

	/**
	 * Sets the userName for this instance.
	 * 
	 * @param userName
	 *            The userName.
	 */
	public abstract void setUserName(String userName);

	/**
	 * Gets the authorId for this instance.
	 * 
	 * @return The authorId.
	 */
	public abstract String getAuthorId();

	/**
	 * Sets the authorId for this instance.
	 * 
	 * @param authorId
	 *            The authorId.
	 */
	public abstract void setAuthorId(String authorId);

	/**
	 * Determines if this instance is expert.
	 * 
	 * @return The expert.
	 */
	public abstract boolean isExpert();

	/**
	 * Sets whether or not this instance is expert.
	 * 
	 * @param expert
	 *            The expert.
	 */
	public abstract void setExpert(boolean expert);

	/**
	 * Determines if this instance is usingTemporaryPassword.
	 * 
	 * @return The usingTemporaryPassword.
	 */
	public abstract boolean isUsingTemporaryPassword();

	/**
	 * Sets whether or not this instance is usingTemporaryPassword.
	 * 
	 * @param usingTemporaryPassword
	 *            The usingTemporaryPassword.
	 */
	public abstract void setUsingTemporaryPassword(
			boolean usingTemporaryPassword);

	/**
	 * Gets the object as a JSON string
	 *
	 * @return The json for this object
	 */
	public abstract String toJSON();

}