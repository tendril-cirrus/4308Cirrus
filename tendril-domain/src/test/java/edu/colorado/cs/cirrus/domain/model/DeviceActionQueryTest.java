package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DeviceActionQueryTest {
	@Test
	public void canDeserializeDeviceActionQuery1() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction1.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery2() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction2.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery3() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction3.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery4() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction4.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery5() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction5.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery6() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction6.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery7() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction7.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery8() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction8.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void canDeserializeDeviceActionQuery9() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/QueryDeviceAction9.xml");
		try {
			DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
			System.err.println(exampleUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
