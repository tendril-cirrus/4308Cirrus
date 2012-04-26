package edu.colorado.cs.cirrus.android;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import android.util.Log;
import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.intf.ITendril;
import edu.colorado.cs.cirrus.domain.intf.TendrilUrls;
import edu.colorado.cs.cirrus.domain.model.AccessGrant;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.Device;
import edu.colorado.cs.cirrus.domain.model.DeviceData;
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

public class TendrilTemplate implements ITendril {
    private static final String TAG = "TendrilTemplate";
    private static TendrilTemplate instance;

    public static TendrilTemplate get() {
        if (instance == null) {
            instance = new TendrilTemplate();
        }
        return instance;
    }

    private HttpEntity<?> requestEntity;
    private HttpHeaders requestHeaders;
    private final RestTemplate restTemplate;
    private AccessGrant accessGrant = null;
    private User user = null;
    private UserProfile userProfile = null;
    private ExternalAccountId externalAccountId = null;
    private Devices devices = null;

    private Device tstat = null;

    private TendrilTemplate() {
        System.err.println("Initializing TendrilTemplate");

        this.restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        // The HttpComponentsClientHttpRequestFactory uses the
        // org.apache.http package to make network requests
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(HttpUtils.getNewHttpClient()));
    }

    public String logIn(String userName, String password) throws TendrilException {
        Log.i(TAG, "logIn attempt: username: " + userName + ", password: " + password);
        String accessToken = authorize(false, userName, password);
        setRequestEntity();
        Log.i(TAG, "login successful! access token: " + accessGrant.getAccess_token());
        return accessToken;
    }

    private void setRequestEntity() {
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(acceptableMediaTypes);
        requestHeaders.setContentType(MediaType.APPLICATION_XML);
        requestHeaders.set("access_token", this.accessGrant.getAccess_token());
        requestEntity = new HttpEntity<Object>(requestHeaders);
    }

    public void useAccessToken(String accessToken) {
        accessGrant = new AccessGrant();
        accessGrant.setAccess_token(accessToken);
        setRequestEntity();
    }

    private String authorize(boolean refresh, String userName, String password) {
        DateTime expiration = new DateTime();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("Accept", "application/json");
        params.set("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add("scope", TendrilUrls.SCOPE);

        if (refresh) {
            formData.add("grant_type", "refresh_token");
            formData.add("refresh_token", accessGrant.getRefresh_token());
        }
        else {
            formData.add("client_id", TendrilUrls.APP_KEY);
            formData.add("client_secret", TendrilUrls.APP_SECRET);
            formData.add("grant_type", "password");
            formData.add("username", userName);
            formData.add("password", password);
        }
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        requestHeaders.set("Accept", "application/json");
        // Populate the MultiValueMap being serialized and headers in an
        // HttpEntity object to use for the request
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                formData, requestHeaders);

        ResponseEntity<AccessGrant> response = restTemplate.exchange(TendrilUrls.ACCESS_TOKEN_URL, HttpMethod.POST,
                requestEntity, AccessGrant.class);

        System.err.println(response);
        accessGrant = response.getBody();
        accessGrant.setExpirationDateTime(expiration.plusSeconds((int) accessGrant.getExpires_in()));
        System.err.println(accessGrant);
        return accessGrant.getAccess_token();
    }

    // TENDRIL's API is not working well- some date ranges return 500 error for no known reason
    public CostAndConsumption fetchCostAndConsumption(Resolution resolution, DateTime from, DateTime to,
            int limitToLatest) throws TendrilException {
        String fromString = from.toString(ISODateTimeFormat.dateTimeNoMillis());
        String toString = to.toString(ISODateTimeFormat.dateTimeNoMillis());
        System.err.println(fromString);
        System.err.println(toString);

        Object[] vars = { resolution.name(), fromString, toString, limitToLatest };
        ResponseEntity<CostAndConsumption> costAndConsumption;

        try {
            costAndConsumption = restTemplate.exchange(TendrilUrls.GET_HISTORICAL_COST_AND_CONSUMPTION_URL,
                    HttpMethod.GET, requestEntity, CostAndConsumption.class, vars);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        return costAndConsumption.getBody();

    }

    public CostAndConsumption fetchCostAndConsumptionRange(DateTime from, DateTime to) throws TendrilException {
        return fetchCostAndConsumption(Resolution.RANGE, from, to, 1);

    }

    public Devices fetchDevices() throws TendrilException {
        ResponseEntity<Devices> devices;
        try {
            devices = restTemplate.exchange(TendrilUrls.GET_DEVICE_LIST_URL, HttpMethod.GET, requestEntity,
                    Devices.class);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }

        return devices.getBody();
    }

    public ExternalAccountId fetchExternalAccountId() throws TendrilException {

        ResponseEntity<ExternalAccountId> response;

        try {
            response = restTemplate.exchange(TendrilUrls.GET_USER_EXTERNAL_ACCOUNT_ID_URL, HttpMethod.GET,
                    requestEntity, ExternalAccountId.class);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        // System.err.println(response.getBody());
        this.externalAccountId = response.getBody();
        return externalAccountId;
    }

    // Tendril's API is not working consistently enough to test this
    private MeterReadings fetchMeterReadings(DateTime from, DateTime to, Integer limitToLatest, Source source)
            throws TendrilException {

        String fromString = from.toString(ISODateTimeFormat.dateTimeNoMillis());
        String toString = to.toString(ISODateTimeFormat.dateTimeNoMillis());

        Object[] vars = { getExternalAccountId(), fromString, toString, limitToLatest, "ACTUAL" };
        System.err.println("vars: ");
        for (Object o : vars) {
            System.err.println(o.toString());
        }

        ResponseEntity<MeterReadings> meterReadings;
        try {
            meterReadings = restTemplate.exchange(TendrilUrls.GET_METER_READINGS_URL, HttpMethod.GET, requestEntity,
                    MeterReadings.class, vars);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }

        System.err.println(meterReadings.getBody());
        return meterReadings.getBody();
    }

    public MeterReadings fetchMeterReadingsRange(DateTime from, DateTime to) throws TendrilException {
        return fetchMeterReadings(from, to, 100, Source.ACTUAL);
    }

    public PricingProgram fetchPricingProgram() throws TendrilException {

        ResponseEntity<PricingProgram> pricingSchedule;
        try {
            pricingSchedule = restTemplate.exchange(TendrilUrls.GET_PRICING_PROGRAM_URL, HttpMethod.GET, requestEntity,
                    PricingProgram.class);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        return pricingSchedule.getBody();

    }

    // This does not currently work- API documentation is inconsistent
    public PricingSchedule fetchPricingSchedule(DateTime from, DateTime to) throws TendrilException {
        Object[] vars = { from.toString(ISODateTimeFormat.dateTimeNoMillis()),
                to.toString(ISODateTimeFormat.dateTimeNoMillis()) };

        ResponseEntity<PricingSchedule> response;
        try {
            response = restTemplate.exchange(TendrilUrls.GET_PRICING_SCHEDULE_URL, HttpMethod.GET, requestEntity,
                    PricingSchedule.class, vars);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        // System.err.println(response.getBody());
        return response.getBody();
    }

    private String fetchThermostatDeviceRequestId() throws TendrilException {
        GetThermostatDataRequest gtdr = new GetThermostatDataRequest();
        gtdr.setDeviceId(getTstat().getDeviceId());
        gtdr.setLocationId(getLocationId());
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        String gtdrString = "<getThermostatDataRequest xmlns=\"http://platform.tendrilinc.com/tnop/extension/ems\""
                + " deviceId=\"001db700000246f5\"" + " locationId=\"74\">" + "</getThermostatDataRequest>";

        System.err.println("gtdr: " + gtdrString);
        HttpEntity<String> requestEntity = new HttpEntity<String>(gtdrString, requestHeaders);

        GetThermostatDataRequest gtdrResponse = null;
        try {
            ResponseEntity<GetThermostatDataRequest> response = restTemplate.exchange(
                    TendrilUrls.POST_DEVICE_ACTION_URL, HttpMethod.POST, requestEntity, GetThermostatDataRequest.class);

            gtdrResponse = response.getBody();
            System.err.println(gtdrResponse);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        return gtdrResponse.getRequestId();
    }

    public User fetchUser() throws TendrilException {
        ResponseEntity<User> response;
        try {
            response = restTemplate.exchange(TendrilUrls.GET_USER_INFO_URL, HttpMethod.GET, requestEntity, User.class);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        user = response.getBody();
        return user;
    }

    // throws a 404 even for current-user. See Tendril's "try it" page
    public UserProfile fetchUserProfile() throws TendrilException {

        ResponseEntity<UserProfile> response;
        try {
            response = restTemplate.exchange(TendrilUrls.GET_USER_PROFILE_URL, HttpMethod.GET, requestEntity,
                    UserProfile.class);
        }
        catch (Exception e) {
            throw new TendrilException(e);
        }
        System.err.println(response.getBody());
        userProfile = response.getBody();
        return userProfile;
    }

    public Devices getDevices() throws TendrilException {
        if (devices == null) devices = fetchDevices();
        return devices;
    }

    public String getExternalAccountId() throws TendrilException {
        if (this.externalAccountId == null) fetchExternalAccountId();
        return externalAccountId.getExternalAccountId();
    }

    private String getLocationId() throws TendrilException {
        if (user == null) fetchUser();
        return user.getId();
    }

    public GetThermostatDataRequest getThermostatData() throws TendrilException {
        Object[] vars = { fetchThermostatDeviceRequestId() };
        GetThermostatDataRequest gtdrResponse = null;
        String requestState = "In Progress";
        boolean firstTry = true;
        while (requestState.equals("In Progress")) {
            try {
                if (!firstTry) {
                    System.err.println("Waiting 2 seconds for device status..");
                    Thread.sleep(2000);
                }
                firstTry = false;
                ResponseEntity<GetThermostatDataRequest> response = restTemplate.exchange(
                        TendrilUrls.GET_DEVICE_ACTION_DATA, HttpMethod.GET, requestEntity,
                        GetThermostatDataRequest.class, vars);

                gtdrResponse = response.getBody();
                System.err.println(response.getBody());
                requestState = gtdrResponse.getRequestState();
            }

            catch (HttpClientErrorException e) {
                throw new TendrilException(e);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return gtdrResponse;
    }

    public Device getTstat() throws TendrilException {
        if (tstat == null) {
            for (Device d : getDevices().getDevice()) {
                if (d.getCategory().equalsIgnoreCase(TendrilUrls.THERMOSTAT_CATEGORY)) {
                    tstat = d;
                    System.err.println("tstat: " + tstat);
                    break;
                }
            }
        }
        return tstat;
    }

    public User getUser() throws TendrilException {
        if (user == null) fetchUser();
        return user;
    }

    public UserProfile getUserProfile() throws TendrilException {
        if (this.userProfile == null) {
            this.userProfile = fetchUserProfile();
        }
        return this.userProfile;
    }

    public static void logOut() {
        // TODO: actually log out of Tendril server
        instance = null;
    }

    public SetThermostatDataRequest setTstatSetpoint(Float setpoint) throws TendrilException {
        SetThermostatDataRequest stdr = new SetThermostatDataRequest();
        stdr.setDeviceId(getTstat().getDeviceId());
        stdr.setLocationId(getLocationId());
        stdr.setRequestId("none");
        DeviceData data = new DeviceData();
        data.setMode("Heat");
        data.setSetpoint(setpoint.toString());
        data.setTemperatureScale("Fahrenheit");

        stdr.setData(data);

        HttpEntity<SetThermostatDataRequest> requestEntity = new HttpEntity<SetThermostatDataRequest>(stdr,
                requestHeaders);

        SetThermostatDataRequest stdrResponse = null;
        try {

            ResponseEntity<SetThermostatDataRequest> response = restTemplate.exchange(
                    TendrilUrls.POST_DEVICE_ACTION_URL, HttpMethod.POST, requestEntity, SetThermostatDataRequest.class);

            stdrResponse = response.getBody();
            System.err.println(stdrResponse);
        }
        catch (HttpClientErrorException e) {
            e.printStackTrace();
            System.err.println(e.getResponseBodyAsString());
        }
        return stdrResponse;
    }

    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
