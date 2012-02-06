package org.springframework.android.showcase.tendril;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class TendrilConnectionFactory extends OAuth2ConnectionFactory<Tendril> {



	public TendrilConnectionFactory(String tendrilAppKey,
			String tendrilAppSecret) {
		super("tendril", new TendrilServiceProvider(tendrilAppKey, tendrilAppSecret), new TendrilAdapter());
	}
}
