package edu.colorado.cs.cirrus.domain.intf;

/**
 * Contains static fields with Tendril URLs and other Strings as documented on Tendril's web site: <a
 * href="http://dev.tendrilinc.com/docs/api_overview">http://dev.tendrilinc.com/docs/api_overview</a>
 * 
 * @author drichelson
 * 
 */
public class TendrilUrls {

    public static final String BASE_URL = "https://dev.tendrilinc.com/connect/";
    public static final String ACCESS_TOKEN_URL = "https://dev.tendrilinc.com/oauth/access_token";
    // private static final String LOGOUT_URL = "https://dev.tendrilinc.com/oauth/logout";
    public static final String APP_KEY = "925272ee5d12eac858aeb81949671584";
    public static final String APP_SECRET = "3230f8f0aa064bea145d425c57fe8679";
    public static final String SCOPE = "offline_access";
    public static final String THERMOSTAT_CATEGORY = "Thermostat";
    public static final String GET_USER_INFO_URL = BASE_URL + "user/current-user";
    public static final String GET_USER_PROFILE_URL = BASE_URL + "user/current-user/profile";
    // private static final String GET_USER_LOCATION_PROFILE_URL = BASE_URL
    // + "user/current-user/account/default-acccount/location/default-location/profile/household";
    public static final String GET_USER_EXTERNAL_ACCOUNT_ID_URL = BASE_URL
            + "user/current-user/account/default-account";
    public static final String GET_METER_READINGS_URL = BASE_URL
            + "meter/read;external-account-id={external-account-id};from={from};to={to};limit-to-latest={limit-to-latest};source={source}";
    public static final String GET_HISTORICAL_COST_AND_CONSUMPTION_URL = BASE_URL
            + "user/current-user/account/default-account/consumption/{resolution};from={from};to={to};limit-to-latest={limit-to-latest}";
    // private static final String GET_PROJECTED_COST_AND_CONSUMPTION_URL = BASE_URL
    // + "user/current-user/account/default-account/consumption/{resolution}/projection;source={source}";
    public static final String GET_PRICING_PROGRAM_URL = BASE_URL
            + "user/current-user/account/default-account/pricing/current-pricing-program";
    public static final String GET_PRICING_SCHEDULE_URL = BASE_URL
            + "account/default-account/pricing/schedule;from={from};to={to}";
    public static final String GET_DEVICE_LIST_URL = BASE_URL
            + "user/current-user/account/default-account/location/default-location/network/default-network/device;include-extended-properties=true";
    public static final String GET_DEVICE_ACTION_DATA = BASE_URL + "device-action/{requestId}";
    public static final String POST_DEVICE_ACTION_URL = BASE_URL + "device-action";
    // private static final String GET_COST_AND_CONSUMPTION_MY_NEIGHBORS_URL = BASE_URL
    // + "user/current-user/account/default-account/comparison/myneighbors/{resolution};from={from};to={to}";
    // private static final String GET_COST_AND_CONSUMPTION_BASELINEACTUAL_URL = BASE_URL
    // + "user/current-user/account/default-account/comparison/baselineactual/{resolution};asof={asof}";

}
