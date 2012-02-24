package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class CustomerAgreement{
	@Element
	String mRID;//customer ID

	public CustomerAgreement(String mRID) {
		super();
		this.mRID = mRID;
	}
	
	public CustomerAgreement() {
		super();
	}

	public String getmRID() {
		return mRID;
	}

	public void setmRID(String mRID) {
		this.mRID = mRID;
	}

	@Override
	public String toString() {
		return "CustomerAgreement [mRID=" + mRID + "]";
	}
	
	
}