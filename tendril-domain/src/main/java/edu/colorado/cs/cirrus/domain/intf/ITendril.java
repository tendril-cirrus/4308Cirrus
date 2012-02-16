package edu.colorado.cs.cirrus.domain.intf;

import org.joda.time.DateTime;

/**
 * interface for specifying a set of operations for interacting with Tendril
 * 
 * @author drichelson
 * 
 */
public interface ITendril {
	/**
	 * Checks for a valid access token. 
	 * 
	 * @return
	 */
	boolean isConnected();
	
	/**
	 * Deletes access token, requiring user to log in again in order to 
	 * keep using the service. Returns success status of log out action.
	 * @return
	 */
	boolean logOut();
	
	/**
	 * Logs in using 'OAuthy' 0/1 legged authentication. Returns success status
	 * 
	 * @param username
	 * @param Password
	 * @return
	 */
	boolean logIn(String username, String Password);
	
	String fetchUserInfo();

	String fetchPricingSchedule(DateTime from, DateTime to);

	String fetchDeviceList();

}
