package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class ExternalAccountId {

	public ExternalAccountId() {
	}

	public ExternalAccountId(String externalAccountId, String id) {
		super();
		this.externalAccountId = externalAccountId;
		this.id = id;
	}

	@Attribute
	String externalAccountId;

	//TODO: make sure this works since it really is called @id
	@Attribute
	String id;

	public String getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(String externalAccountId) {
		this.externalAccountId = externalAccountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExternalAccountId [externalAccountId=" + externalAccountId
				+ ", id=" + id + "]";
	}

}
