//package edu.colorado.cs.cirrus.domain.model;
//import static org.junit.Assert.*;
//
//import java.io.File;
//
//import org.junit.Test;
//import org.simpleframework.xml.Serializer;
//import org.simpleframework.xml.core.Persister;
//
//
//public class UsersTest {
//    
//    @Test
//    public void canDeserializeUsers() {
//        Serializer serializer = new Persister();
//        File source = new File("src/test/resources/Users.xml");
//
//        try {
//            Users exampleUsers = serializer.read(Users.class, source);
//            System.err.println(exampleUsers);
//
//        }  catch (Exception e) {
//            e.printStackTrace();
//            fail();
//        }
//
//    }
//}
