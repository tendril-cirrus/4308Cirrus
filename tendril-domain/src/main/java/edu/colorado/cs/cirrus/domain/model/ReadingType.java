package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class ReadingType{
	@Element
	String mRID;//meter ID
	
	@Element
	String aliasName;
	
	@Element
	int channelNumber;
	
	@Element
	String defaultQuality;
	
	@Element
	float intervalLength;
	
	@Element
	String kind;
	
	@Element
	String multiplier;
	
	@Element
	String name;
	
	@Element
	String unit;

	public ReadingType(String mRID, String aliasName, int channelNumber,
			String defaultQuality, int intervalLength, String kind,
			String multiplier, String name, String units) {
		super();
		this.mRID = mRID;
		this.aliasName = aliasName;
		this.channelNumber = channelNumber;
		this.defaultQuality = defaultQuality;
		this.intervalLength = intervalLength;
		this.kind = kind;
		this.multiplier = multiplier;
		this.name = name;
		this.unit = units;
	}
	
	public ReadingType(){super();}

	public String getmRID() {
		return mRID;
	}

	public void setmRID(String mRID) {
		this.mRID = mRID;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public int getChannelNumber() {
		return channelNumber;
	}

	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}

	public String getDefaultQuality() {
		return defaultQuality;
	}

	public void setDefaultQuality(String defaultQuality) {
		this.defaultQuality = defaultQuality;
	}

	public float getIntervalLength() {
		return intervalLength;
	}

	public void setIntervalLength(float intervalLength) {
		this.intervalLength = intervalLength;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}