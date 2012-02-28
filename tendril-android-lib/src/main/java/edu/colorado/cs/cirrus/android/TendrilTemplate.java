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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import edu.colorado.cs.cirrus.domain.intf.ITendril;
import edu.colorado.cs.cirrus.domain.model.AccessGrant;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.ExternalAccountId;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.User;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

public class TendrilTemplate implements ITendril {

	private static final String BASE_URL = "http://dev.tendrilinc.com/connect/";
	private static final String ACCESS_TOKEN_URL = "https://dev.tendrilinc.com/oauth/access_token";
	private static final String APP_KEY = "925272ee5d12eac858aeb81949671584";
	private static final String APP_SECRET = "3230f8f0aa064bea145d425c57fe8679";
	private static final String SCOPE = "account, billing, consumption, greenbutton, device";
	private static final String USERNAME = "csci4138@tendrilinc.com";
	private static final String PASSWORD = "password";

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
			+ "user/current-user/account/default-account/pricing/current-pricing-program";
	private static final String GET_PRICING_SCHEDULE_URL = BASE_URL
			+ "pricing/schedule;external-account-id={external-account-id}from={from};to={to}";
	private static final String GET_DEVICE_LIST_URL = BASE_URL
			+ "user/current-user/account/default-account/location/default-location/network/default-network/device;include-extended-properties=true";
	private static final String POST_DEVICE_ACTION_URL = BASE_URL
			+ "device-action";
	private static final String GET_COST_AND_CONSUMPTION_MY_NEIGHBORS_URL = BASE_URL
			+ "user/current-user/account/default-account/comparison/myneighbors/{resolution};from={from};to={to}";
	private static final String GET_COST_AND_CONSUMPTION_BASELINEACTUAL_URL = BASE_URL
			+ "user/current-user/account/default-account/comparison/baselineactual/{resolution};asof={asof}";

	private HttpEntity<?> requestEntity;
	private RestTemplate restTemplate;
	// private String accessToken = "uninitialized";
	// private String refreshToken = "uninitialized";
	private long expiresIn = 0l;
	private AccessGrant accessGrant;
	private static final String TAG = "TendrilTemplate";
	private User user;
	private UserProfile userProfile;
	private ExternalAccountId externalAccountId;

	/**
	 * Create a new instance of TendrilTemplate. This constructor creates the
	 * TendrilTemplate using a username and password.
	 * 
	 * 
	 * @param login
	 * @param password
	 **/
	public TendrilTemplate(String login, String password) {
		System.err.println("Initializing TendrilTemplate1");

		this.restTemplate = new RestTemplate();
		// The HttpComponentsClientHttpRequestFactory uses the
		// org.apache.http package to make network requests
		restTemplate
				.setRequestFactory(new HttpComponentsClientHttpRequestFactory(
						HttpUtils.getNewHttpClient()));

		logIn();
		setRequestEntity();
	}

	private void setRequestEntity() {
		HttpHeaders requestHeaders = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		requestHeaders.setAccept(acceptableMediaTypes);
		requestHeaders.setContentType(MediaType.APPLICATION_XML);
		requestHeaders.set("access_token", this.accessGrant.getAccess_token());

		// Populate the headers in an HttpEntity object to use for the
		// request
		this.requestEntity = new HttpEntity<Object>(requestHeaders);

		// public RestOperations restOperations() {
		// return getRestTemplate();
		// }

		// protected void configureRestTemplate(RestTemplate restTemplate) {
		// restTemplate.setErrorHandler(new TendrilErrorHandler());
		// }

	}

	private String getPassword() {
		return PASSWORD;
	}

	private String getUsername() {
		return USERNAME;
	}

	public ExternalAccountId fetchExternalAccountId() {

		ResponseEntity<ExternalAccountId> response = restTemplate.exchange(
				GET_USER_EXTERNAL_ACCOUNT_ID_URL, HttpMethod.GET,
				requestEntity, ExternalAccountId.class);
		System.err.println(response.getBody());
		this.externalAccountId = response.getBody();
		return externalAccountId;
	}

	public ExternalAccountId getExternalAccountId() {
		if (this.externalAccountId != null)
			return this.externalAccountId;
		else
			return fetchExternalAccountId();
	}

	public User fetchUser() {
		ResponseEntity<User> response = restTemplate.exchange(
				GET_USER_INFO_URL, HttpMethod.GET, requestEntity, User.class);
		System.err.println(response.getBody());
		this.user = response.getBody();
		return user;
	}

	public User getUser() {
		if (this.user != null)
			return this.user;
		else
			return fetchUser();
	}

	public Devices fetchDevices() {
		ResponseEntity<Devices> devices = restTemplate.exchange(
				GET_DEVICE_LIST_URL, HttpMethod.GET, requestEntity,
				Devices.class);

		System.err.println(devices.getBody());
		return devices.getBody();
	}

	// FIXME: this does not currently work- API documentation is inconsistent
	public String fetchPricingSchedule(DateTime from, DateTime to) {
		String fromString = from.toString(ISODateTimeFormat.dateTimeNoMillis());
		String toString = to.toString(ISODateTimeFormat.dateTimeNoMillis());
		System.err.println(fromString);

		Object[] vars = { getExternalAccountId().getId(), fromString, toString };
		ResponseEntity<String> profile = restTemplate.exchange(
				GET_PRICING_SCHEDULE_URL, HttpMethod.GET, requestEntity,
				String.class, vars);
		return profile.getBody();
	}

	public PricingProgram fetchPricingProgram() {
		// Object[] vars = { getExternalAccountId().getId() };
		ResponseEntity<PricingProgram> pricingSchedule = restTemplate.exchange(
				GET_PRICING_PROGRAM_URL, HttpMethod.GET, requestEntity,
				PricingProgram.class);
		return pricingSchedule.getBody();

	}

	// private RestOperations getRestTemplate() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// private String prettyize(String str) {
	// Gson gson = new GsonBuilder().setPrettyPrinting().create();
	// JsonParser jp = new JsonParser();
	// JsonElement je = jp.parse(str);
	// String prettyJsonString = gson.toJson(je);
	// return prettyJsonString;
	// }

	public boolean isConnected() {
		DateTime now = new DateTime();
		if (accessGrant != null && accessGrant.getExpirationDateTime() != null) {
			if (now.isBefore(accessGrant.getExpirationDateTime()
					.minusMinutes(5))) {
				System.err
						.println("isConnected(): Valid access token! expires: "
								+ accessGrant.getExpirationDateTime());
				return true;
			} else {
				return refreshToken();
			}
		} else {
			return logIn();
		}
	}

	public boolean logOut() {
		// TODO: actually log out of Tendril server
		accessGrant = null;
		return true;

	}

	public boolean logIn() {
		return authorize(false);
	}

	private boolean refreshToken() {
		return authorize(true);
	}

	private boolean authorize(boolean refresh) {

		DateTime expiration = new DateTime();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("Accept", "application/json");
		params.set("Content-Type", "application/x-www-form-urlencoded");

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();

		if (refresh) {
			formData.add("grant_type", "refresh_token");
			formData.add("refresh_token", accessGrant.getRefresh_token());
		} else {
			formData.add("client_id", APP_KEY);
			formData.add("client_secret", APP_SECRET);
			formData.add("grant_type", "password");
			formData.add("username", getUsername());
			formData.add("password", getPassword());
		}
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		requestHeaders.set("Accept", "application/json");
		// Populate the MultiValueMap being serialized and headers in an
		// HttpEntity object to use for the request
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
				formData, requestHeaders);

		ResponseEntity<AccessGrant> response = restTemplate.exchange(
				ACCESS_TOKEN_URL, HttpMethod.POST, requestEntity,
				AccessGrant.class);

		System.err.println(response);
		accessGrant = response.getBody();
		accessGrant.setExpirationDateTime(expiration
				.plusSeconds((int) accessGrant.getExpires_in()));

		return true;
	}

}
