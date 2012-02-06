package org.springframework.android.showcase.tendril;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.GroupOperations;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.MediaOperations;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.social.facebook.api.PlacesOperations;
import org.springframework.social.facebook.api.UserOperations;

import org.springframework.social.facebook.api.impl.json.FacebookModule;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class TendrilTemplate extends AbstractOAuth2ApiBinding implements
		Tendril {

	private ObjectMapper objectMapper;

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates a new
	 * FacebookTemplate able to perform unauthenticated operations against
	 * Facebook's Graph API. Some operations do not require OAuth
	 * authentication. For example, retrieving a specified user's profile or
	 * feed does not require authentication (although the data returned will be
	 * limited to what is publicly available). A FacebookTemplate created with
	 * this constructor will support those operations. Those operations
	 * requiring authentication will throw {@link NotAuthorizedException}.
	 */
	public TendrilTemplate() {
		initialize();
	}

	/**
	 * Create a new instance of TendrilTemplate. This constructor creates the
	 * TendrilTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Tendril after a successful OAuth 2
	 *            authentication
	 */
	public TendrilTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(requestFactory));
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

	// AbstractOAuth2ApiBinding hooks
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_10;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new TendrilErrorHandler());
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super
				.getJsonMessageConverter();
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new FacebookModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
	}

}
