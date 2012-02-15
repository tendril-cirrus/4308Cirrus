package edu.colorado.cs.cirrus.domain.intf;

import org.joda.time.DateTime;

/**
 * interface for specifying a set of operations for interacting with Tendril
 * 
 * @author drichelson
 * 
 */
public interface ITendril {
	String fetchUserInfo();

	String fetchPricingSchedule(DateTime from, DateTime to);

	String fetchDeviceList();

}
