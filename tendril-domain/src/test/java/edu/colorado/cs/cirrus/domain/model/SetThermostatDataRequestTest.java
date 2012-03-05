package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SetThermostatDataRequestTest {

	@Test
	public void canDeserializeSetThermostatDataRequest() {
		Serializer serializer = new Persister();
		File source = new File(
				"src/test/resources/SetThermostatDataRequest.xml");

		try {
			SetThermostatDataRequest exampleSetThermostatDataRequest = serializer
					.read(SetThermostatDataRequest.class, source);
			System.err.println(exampleSetThermostatDataRequest);

		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void canSerializeSetThermostatData(){
	//	Deserializer deserializer = new SetThermostatDataRequestTest()
		
		
	}

}
