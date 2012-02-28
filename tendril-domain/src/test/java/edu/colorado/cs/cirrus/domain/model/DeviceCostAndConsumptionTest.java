package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DeviceCostAndConsumptionTest {

    @Test
    public void canDeserializeDeviceCostAndConsumption() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/DeviceCostAndConsumption.xml");

        try {
            DeviceCostAndConsumption exampleDeviceCostAndConsumption = serializer.read(
                    DeviceCostAndConsumption.class, source);
            System.err.println(exampleDeviceCostAndConsumption);

        } catch (Exception e) {
            e.printStackTrace();
            fail();

        }
    }

}
