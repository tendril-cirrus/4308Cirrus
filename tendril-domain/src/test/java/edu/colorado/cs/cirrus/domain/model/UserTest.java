package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class UserTest {

	@Test
	public void canDeserializeUser() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/User.xml");

		try {
			UserInfo exampleUser = serializer.read(UserInfo.class, source);
			
			System.err.println(exampleUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block
			
		}
		
		
		
	}

}
