package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ProjectedCostAndConsumptionTest {
	@Test
    public void canDeserializeCostAndConsumption() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/ProjectedCostAndConsumption.xml");

        try {
            CostAndConsumption exampleCostAndConsumption = serializer.read(
                    CostAndConsumption.class, source);
            System.err.println(exampleCostAndConsumption);

        } catch (Exception e) {
            e.printStackTrace();
            fail();

        }
    }
}
