package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class MeterAsset{
	@Element
	String mRID;//meter ID

	public MeterAsset(String mRID) {
		super();
		this.mRID = mRID;
	}
	
	public MeterAsset() {
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
		return "MeterAsset [mRID=" + mRID + "]";
	}
	
	
}