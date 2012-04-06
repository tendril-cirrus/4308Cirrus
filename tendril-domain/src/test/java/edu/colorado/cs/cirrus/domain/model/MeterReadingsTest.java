package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class MeterReadingsTest {

    // @Ignore
    @Test
    public void canDeserializeMeterReading() {
        
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/MeterReadings.xml");
        try {
            MeterReadings exampleReading = serializer.read(MeterReadings.class, source);
            System.err.println(exampleReading);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
