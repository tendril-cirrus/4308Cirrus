package edu.colorado.cs.cirrus.domain.model;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class ExternalAccountIdTest {

	@Test
	public void canDeserializeExternalAccountId() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/ExternalAccountId.xml");

		try {
			ExternalAccountId externalAccountId = serializer.read(ExternalAccountId.class, source);
			System.err.println(externalAccountId);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block
			
		}
		
		
		
	}

}