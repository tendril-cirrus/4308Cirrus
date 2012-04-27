package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

//child of MeterReading
//@Namespace(reference="http://iec.ch/TC57/2009/MeterReadings#",prefix="ns2")
public class Readings {
    @Element
    // (required=false)//(name="timeStamp")
    private String timeStamp;

    @Element
    float value;

    @Element
    ReadingQualities ReadingQualities;

    @Element
    ReadingTypeReference ReadingType;// not to be confused with the ReadingType class. Thanks Tendril

    public Readings(String timeStamp, float value, ReadingQualities readingQualities, ReadingTypeReference readingType) {
        super();
        this.timeStamp = timeStamp;
        this.value = value;
        this.ReadingQualities = readingQualities;
        this.ReadingType = readingType;
    }

    public Readings() {
        super();
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String datetime) {
        this.timeStamp = datetime;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public ReadingQualities getReadingQualities() {
        return ReadingQualities;
    }

    public void setReadingQualities(ReadingQualities readingQualities) {
        this.ReadingQualities = readingQualities;
    }

    public ReadingTypeReference getReadingType() {
        return ReadingType;
    }

    public void setReadingType(ReadingTypeReference readingType) {
        this.ReadingType = readingType;
    }

    @Override
    public String toString() {
        return "Readings [timeStamp=" + timeStamp + ", value=" + value + ", ReadingQualities=" + ReadingQualities
                + ", ReadingType=" + ReadingType + "]";
    }

}
