package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PricingProgramTest {

	@Test
	public void canDeserializeUser() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/PricingProgram.xml");

		try {
			PricingProgram examplePricingProgram = serializer.read(
					PricingProgram.class, source);

			System.err.println(examplePricingProgram);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block

		}
	}

}
