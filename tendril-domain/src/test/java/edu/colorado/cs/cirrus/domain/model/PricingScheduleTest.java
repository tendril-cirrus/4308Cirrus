package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PricingScheduleTest {

	@Test
	public void canDeserializePricingSchedule() {
		Serializer serializer = new Persister();
		File source = new File("src/test/resources/PricingSchedule.xml");

		try {
			PricingSchedule examplePricingSchedule = serializer.read(
					PricingSchedule.class, source);

			System.err.println(examplePricingSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
			// TODO Auto-generated catch block

		}
	}

}
