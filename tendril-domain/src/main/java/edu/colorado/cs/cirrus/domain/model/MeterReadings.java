/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

//@Namespace(reference="http://iec.ch/TC57/2009/MeterReadings#",prefix="ns2")
@Root
public class MeterReadings {
	@Element(required=false)
	MeterReading MeterReading;
	
	@Element//(required=false)
	ReadingType ReadingType;

	public MeterReadings() {
		super();
	}

	public MeterReadings(MeterReading meterReading, ReadingType readingType) {
		super();
		this.MeterReading = meterReading;
		this.ReadingType = readingType;
	}

	public MeterReading getMeterReading() {
		return MeterReading;
	}

	public void setMeterReading(MeterReading meterReading) {
		this.MeterReading = meterReading;
	}

	public ReadingType getReadingType() {
		return ReadingType;
	}

	public void setReadingType(ReadingType readingType) {
		this.ReadingType = readingType;
	}

	@Override
	public String toString() {
		return "MeterReadings [MeterReading=" + MeterReading + ", ReadingType="
				+ ReadingType + "]";
	}
	
	
}