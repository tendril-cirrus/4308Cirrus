package org.springframework.android.showcase.tendril;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class TendrilServiceProvider extends AbstractOAuth2ServiceProvider<Tendril> {


	public TendrilServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId, clientSecret,"http://dev.tendrilinc.com/oauth/authorize","http://dev.tendrilinc.com/oauth/access_token" ));
	}

	public Tendril getApi(String accessToken) {
		return new TendrilTemplate(accessToken);
	}
	
}