package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ErrorTest {
	@Test
	public void canDeserializeError(){
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/Error.xml");

		try {
			TendrilErrorResponse error = serializer.read(TendrilErrorResponse.class, source);
			System.err.println(error);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
