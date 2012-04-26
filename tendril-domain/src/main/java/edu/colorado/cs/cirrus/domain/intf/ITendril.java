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

public interface ITendril {

    public abstract String logIn(String userName, String password) throws TendrilException;

    public abstract void useAccessToken(String accessToken);

    // TENDRIL's API is not working well- some date ranges return 500 error for no known reason
    public abstract CostAndConsumption fetchCostAndConsumption(Resolution resolution, DateTime from, DateTime to,
            int limitToLatest) throws TendrilException;

    public abstract CostAndConsumption fetchCostAndConsumptionRange(DateTime from, DateTime to) throws TendrilException;

    public abstract Devices fetchDevices() throws TendrilException;

    public abstract ExternalAccountId fetchExternalAccountId() throws TendrilException;

    public abstract MeterReadings fetchMeterReadingsRange(DateTime from, DateTime to) throws TendrilException;

    public abstract PricingProgram fetchPricingProgram() throws TendrilException;

    // This does not currently work- API documentation is inconsistent
    public abstract PricingSchedule fetchPricingSchedule(DateTime from, DateTime to) throws TendrilException;

    public abstract User fetchUser() throws TendrilException;

    // throws a 404 even for current-user. See Tendril's "try it" page
    public abstract UserProfile fetchUserProfile() throws TendrilException;

    public abstract Devices getDevices() throws TendrilException;

    public abstract String getExternalAccountId() throws TendrilException;

    public abstract GetThermostatDataRequest getThermostatData() throws TendrilException;

    public abstract Device getTstat() throws TendrilException;

    public abstract User getUser() throws TendrilException;

    public abstract UserProfile getUserProfile() throws TendrilException;

    public abstract SetThermostatDataRequest setTstatSetpoint(Float setpoint) throws TendrilException;

}
