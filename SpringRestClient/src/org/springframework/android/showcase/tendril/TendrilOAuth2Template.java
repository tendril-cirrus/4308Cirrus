package org.springframework.android.showcase.tendril;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.util.MultiValueMap;

public class TendrilOAuth2Template implements OAuth2Operations {

	public String buildAuthorizeUrl(GrantType grantType,
			OAuth2Parameters parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public String buildAuthenticateUrl(GrantType grantType,
			OAuth2Parameters parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessGrant exchangeForAccess(String authorizationCode,
			String redirectUri,
			MultiValueMap<String, String> additionalParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessGrant refreshAccess(String refreshToken, String scope,
			MultiValueMap<String, String> additionalParameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
