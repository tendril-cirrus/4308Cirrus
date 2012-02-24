package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class ReadingQualities{
	@Element
	String quality;

	public ReadingQualities(String quality) {
		super();
		this.quality = quality;
	}
	
	public ReadingQualities() {
		super();
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "ReadingQualities [quality=" + quality + "]";
	}
	
	
}