package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DeviceActionTest {

	@Test
	public void canDeserializeDeviceAction() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/DeviceAction.xml");

		try {
			DeviceAction exampleUser = serializer.read(DeviceAction.class, source);
			
			System.err.println(exampleUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block
			
		}
		
		
		
	}
}
