package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class LocationProfileTest {
    
    @Test
    public void canDeserializeLocationProfile() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/LocationProfile.xml");
        
        try {
            LocationProfile exampleLocationProfile = serializer.read(
                    LocationProfile.class, source);
            
            System.err.println(exampleLocationProfile);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        
    }
    
} 
