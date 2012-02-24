package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;

public class ReadingTypeReference {
	@Attribute
	String ref;
	
	public ReadingTypeReference(){super();}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "ReadingTypeReference [ref=" + ref + "]";
	}
	
	
}
