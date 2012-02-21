package edu.colorado.cs.cirrus.domain.model;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class DevicesTest {

	@Test
	public void canDeserializeDevices() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/Devices2.xml");

		try {
			Devices exampleDevices = serializer.read(Devices.class, source);
			System.err.println(exampleDevices);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block
			
		}
		
		
		
	}

}