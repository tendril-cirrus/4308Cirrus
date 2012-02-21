package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class UserProfileTest {

    @Test
    public void canDeserializeUserProfile() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/UserProfile.xml");

        try {
            UserProfile exampleUserProfile = serializer.read(UserProfile.class, source);

            System.err.println(exampleUserProfile);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

}

