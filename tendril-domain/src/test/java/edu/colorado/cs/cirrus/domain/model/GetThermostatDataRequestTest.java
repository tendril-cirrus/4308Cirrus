package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class GetThermostatDataRequestTest {

    @Test
    public void canDeserializeGetThermostatDataRequest() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/GetThermostatDataRequest.xml");

        try {
            fetchThermostatDataRequest exampleGetThermostatDataRequest = serializer.read(
            		fetchThermostatDataRequest.class, source);
            System.err.println(exampleGetThermostatDataRequest);

        } catch (Exception e) {
            e.printStackTrace();
            fail();

        }
    }

}
