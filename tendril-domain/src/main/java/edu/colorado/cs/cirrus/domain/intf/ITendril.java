package edu.colorado.cs.cirrus.domain.intf;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.Device;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.ExternalAccountId;
import edu.colorado.cs.cirrus.domain.model.GetThermostatDataRequest;
import edu.colorado.cs.cirrus.domain.model.MeterReadings;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;
import edu.colorado.cs.cirrus.domain.model.Resolution;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;
import edu.colorado.cs.cirrus.domain.model.User;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

/**
 * Primary interface for accessing Tendril's API: <a href="http://dev.tendrilinc.com">http://dev.tendrilinc.com</a>
 * 
 */
public interface ITendril {

    /**
     * Authenticates with the Tendril server using provided username and password. Internally sets the access token for
     * use within the same session Assumes all API keys are set internally
     * 
     * @param userName
     * @param password
     * @return Access token upon successful login
     * @throws TendrilException
     */

    public String logIn(String userName, String password) throws TendrilException;

    /**
     * Sets the access token. Useful for applications that do not store a user's credentials, but instead store an
     * expiring, revokable access token Note: If the <code>logIn()</code> method is called, calling this method with its
     * return value is not necessary, as the access token is also set upon successful authentication.
     * 
     * @param accessToken
     */
    public void useAccessToken(String accessToken);

    /**
     * Fetches Historical Cost and Consumption
     * 
     * @param resolution
     * @param from
     * @param to
     * @param limitToLatest
     * @return
     * @throws TendrilException
     */
    public CostAndConsumption fetchCostAndConsumption(Resolution resolution, DateTime from, DateTime to,
            int limitToLatest) throws TendrilException;

    public CostAndConsumption fetchCostAndConsumptionRange(DateTime from, DateTime to) throws TendrilException;

    public Devices fetchDevices() throws TendrilException;

    public ExternalAccountId fetchExternalAccountId() throws TendrilException;

    public MeterReadings fetchMeterReadingsRange(DateTime from, DateTime to) throws TendrilException;

    public PricingProgram fetchPricingProgram() throws TendrilException;

    /**
     * 
     * This does not currently work- API documentation is inconsistent
     * 
     * @param from
     * @param to
     * @return
     * @throws TendrilException
     */
    public PricingSchedule fetchPricingSchedule(DateTime from, DateTime to) throws TendrilException;

    public User fetchUser() throws TendrilException;

    /**
     * Throws a 404 even for current-user. See Tendril's "try it" page
     * 
     * @return
     * @throws TendrilException
     */
    public UserProfile fetchUserProfile() throws TendrilException;

    public Devices getDevices() throws TendrilException;

    public String getExternalAccountId() throws TendrilException;

    public GetThermostatDataRequest getThermostatData() throws TendrilException;

    public Device getTstat() throws TendrilException;

    public User getUser() throws TendrilException;

    public UserProfile getUserProfile() throws TendrilException;

    public SetThermostatDataRequest setTstatSetpoint(Float setpoint) throws TendrilException;

}
