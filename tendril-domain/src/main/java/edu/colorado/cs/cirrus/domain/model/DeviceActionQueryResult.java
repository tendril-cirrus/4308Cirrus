package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;

/* This is a crazy fucking class. Tendril returns a bunch of different xml structures
 * for the same type of request. This class has to deal with all of those structures.
 * DeviceActionQuery has an instance of this class (not required). This class is the one 
 * that has to deal with the different possibilities.
 * 
 * I'm planning on making all the elements optional so the deserializer won't complain
 * but then adding extra tests to make sure certain things aren't null*/

public class DeviceActionQueryResult {
	@Attribute
	String type;
	
	
}
