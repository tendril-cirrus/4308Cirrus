package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class User {

	public User() {
	}

	public User(int id, String firstName, String lastName, String emailAddress,
			boolean usingTemporaryPassword, String userName, boolean expert,
			String authorId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.usingTemporaryPassword = usingTemporaryPassword;
		this.userName = userName;
		this.expert = expert;
		this.authorId = authorId;
	}

	@Attribute
	int id;

	@Element
	String firstName;

	@Element
	String lastName;

	@Element
	String emailAddress;

	@Element
	boolean usingTemporaryPassword;

	@Element
	String userName;

	@Element
	boolean expert;

	@Element
	String authorId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isUsingTemporaryPassword() {
		return usingTemporaryPassword;
	}

	public void setUsingTemporaryPassword(boolean usingTemporaryPassword) {
		this.usingTemporaryPassword = usingTemporaryPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isExpert() {
		return expert;
	}

	public void setExpert(boolean expert) {
		this.expert = expert;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailAddress=" + emailAddress
				+ ", usingTemporaryPassword=" + usingTemporaryPassword
				+ ", userName=" + userName + ", expert=" + expert
				+ ", authorId=" + authorId + "]";
	}
}
