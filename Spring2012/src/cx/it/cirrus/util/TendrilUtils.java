/*
 * Insert License Here
*/

package cx.it.cirrus.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.*;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TendrilUtils {
    
    /*
     * Public class variables
     */
    public static String APPLICATION_NAME = "TendrilManager";
    public static String TENDRIL_BASE_URL = "http://";

    /*
     * Private class variables
     */
    private static String CONSUMER_KEY = "";
    private static String CONSUMER_SECRET = "";
    private static String TENDRIL_REQUEST_TOKEN_URL = TENDRIL_BASE_URL + 
                                    "/oauth/request_token";
    private static String TENDRIL_ACCESS_TOKEN_URL = TENDRIL_BASE_URL +
                                    "/oauth/acces_token";
    private static String TENDRIL_AUTHORIZE_URL = TENDRIL_BASE_URL + 
                                    "/oauth/authorize";

    /* 
     * PRIVATE FUNCTIONS
     */

    /*
     * PUBLIC FUNCTIONS
     */

    /* sendSignedRequest()
     * Description: send an HTTP request signed with an Access Token
     *              and Token Secret
     * Arguments: request myRequest - the request to sign and send
     *            String accessToken - the Access Token
     *            String tokenSecret - the Token secret
     * Returns: The HTTP response
     */
    public static HttpResponse sendSignedRequest(HttpUriRequest myRequest, 
                                             String accessToken,
                                             String tokenSecret){
        // create a consumer object and configure it with the access
        // token and token secret obtained from the service provider
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
                CONSUMER_SECRET);
        consumer.setTokenWithSecret(accessToken, tokenSecret);

        // sign the request
        consumer.sign(myRequest);

        // send the request
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(myRequest);
        
        return response;
    }

    /* getOAuthTokens()
     * Description: Have user authenticate with TendrilConect in order to get
     *              an Access Token and Token Secret
     * Arguments: VOID
     * Returns: String[] - returnArray
     *              returnArray[0] - Access Token
     *              returnArray[1] - Token Secret
     */
    public static String[] getOAuthTokens(){

        String[] returnArray = new String[2];
     
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
                CONSUMER_SECRET);

        OAuthProvider provider = new CommonsHttpOAuthProvider(
                                            TENDRIL_REQUEST_TOKEN_URL,
                                            TENDRIL_ACCESS_TOKEN_URL, 
                                            TENDRIL_AUTHORIZE_URL);

        System.out.println("Fetching request token...");

        // we do not support callbacks, thus pass OOB
        String authUrl = provider.retrieveRequestToken(consumer, 
                                                            OAuth.OUT_OF_BAND);
        authUrl = OAuth.addQueryParameters(authUrl, OAuth.OAUTH_CONSUMER_KEY, 
                                           CONSUMER_KEY, "application_name", 
                                           APPLICATION_NAME);

        System.out.println("Request token: " + consumer.getToken());
        System.out.println("Token secret: " + consumer.getTokenSecret());

        System.out.println("Now visit:\n" + authUrl + "\n... and grant this app authorization");
        System.out.println("Enter the PIN code and hit ENTER when you're done:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pin = br.readLine();

        System.out.println("Fetching access token...");

        provider.retrieveAccessToken(consumer, pin);

        System.out.println("Access token: " + consumer.getToken());
        System.out.println("Token secret: " + consumer.getTokenSecret());

        returnArray[0] = consumer.getToken();
        returnArray[1] = consumer.getTokenSecret();

        return returnArray;

    }
}
