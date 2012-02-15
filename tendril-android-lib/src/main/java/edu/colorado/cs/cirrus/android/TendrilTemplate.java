package edu.colorado.cs.cirrus.android;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.domain.intf.ITendril;

public class TendrilTemplate implements ITendril{

	private static final String BASE_URL = "http://dev.tendrilinc.com/connect/";
	private static final String GET_USER_INFO_URL = BASE_URL
			+ "user/current-user";
	private static final String GET_USER_PROFILE_URL = BASE_URL
			+ "user/current-user/profile";
	private static final String GET_USER_LOCATION_PROFILE_URL = BASE_URL
			+ "user/current-user/account/default-acccount/location/default-location/profile/household";
	private static final String GET_USER_EXTERNAL_ACCOUNT_ID_URL = BASE_URL
			+ "user/current-user/account/default-account";
	private static final String GET_METER_READINGS_URL = BASE_URL
			+ "meter/read;external-account-id={external-account-id};from={from};to={to};limit-to-latest={limit-to-latest};source={source}";
	private static final String GET_HISTORICAL_COST_AND_CONSUMPTION_URL = BASE_URL
			+ "user/current-user/account/default-account/consumption/{resolution};external-account-id={external-account-id};from={from};to={to};limit-to-latest={limit-to-latest};source={source}";
	private static final String GET_PROJECTED_COST_AND_CONSUMPTION_URL = BASE_URL
			+ "user/current-user/account/default-account/consumption/{resolution}/projection;source={source}";
	private static final String GET_PRICING_PROGRAM_URL = BASE_URL
			+ "user/current-user/account/default-account/current-pricing-program";
	private static final String GET_PRICING_SCHEDULE_URL = BASE_URL
			+ "account/default-account/pricing/schedule;from={from};to={to}";
	private static final String GET_DEVICE_LIST_URL = BASE_URL
			+ "user/current-user/account/default-account/location/default-location/network/default-network/device;include-extended-properties=true";
	private static final String POST_DEVICE_ACTION_URL = BASE_URL
			+ "device-action";
	private static final String GET_COST_AND_CONSUMPTION_MY_NEIGHBORS_URL = BASE_URL
			+ "user/current-user/account/default-account/comparison/myneighbors/{resolution};from={from};to={to}";
	private static final String GET_COST_AND_CONSUMPTION_BASELINEACTUAL_URL = BASE_URL
			+ "user/current-user/account/default-account/comparison/baselineactual/{resolution};asof={asof}";
	public String fetchUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	public String fetchPricingSchedule(DateTime from, DateTime to) {
		// TODO Auto-generated method stub
		return null;
	}
	public String fetchDeviceList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*// private ObjectMapper objectMapper;
	private HttpEntity<?> requestEntity;


	public TendrilTemplate() {
		// initialize();
	}

	/**
	 * Create a new instance of TendrilTemplate. This constructor creates the
	 * TendrilTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Tendril after a successful OAuth 2
	 *            authentication
	 
	public TendrilTemplate(String accessToken) {
		super(accessToken);
		// Set the Accept header for "application/json"
		
		//TODO: this should be handled by the previous statement- the restTemplate should
		//deal with all auth issues..
		setRequestEntity(accessToken);
	}

	private void setRequestEntity(String accessToken) {
		HttpHeaders requestHeaders = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(acceptableMediaTypes);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set("access_token", accessToken);

		// Populate the headers in an HttpEntity object to use for the
		// request
		this.requestEntity = new HttpEntity<Object>(requestHeaders);
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new TendrilErrorHandler());
	}

	public String fetchUserInfo() throws InterruptedException,
			ExecutionException {

		ResponseEntity<String> profile = getRestTemplate().exchange(
				GET_USER_INFO_URL, HttpMethod.GET, requestEntity, String.class);

		String str = profile.getBody();

		String prettyJsonString = prettyize(str);

		return prettyJsonString;
	}

	public String fetchDeviceList() {
		ResponseEntity<String> profile = getRestTemplate().exchange(
				GET_DEVICE_LIST_URL, HttpMethod.GET, requestEntity,
				String.class);
		return prettyize(profile.getBody());
	}

	

	public String fetchPricingSchedule(DateTime from, DateTime to) {
		String fromString = from.toString(ISODateTimeFormat.dateTimeNoMillis());
		String toString = to.toString(ISODateTimeFormat.dateTimeNoMillis());
		System.err.println(fromString);

		String[] vars = {fromString, toString};
		ResponseEntity<String> profile = getRestTemplate().exchange(
				GET_PRICING_SCHEDULE_URL, HttpMethod.GET, requestEntity,
				String.class, vars);
		return prettyize(profile.getBody());
	}
	
	private String prettyize(String str) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(str);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
	*/

}
