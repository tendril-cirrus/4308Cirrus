/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.android.showcase.tendril;

import org.springframework.android.showcase.AbstractWebViewActivity;
import org.springframework.android.showcase.R;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.DuplicateConnectionException;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.support.ParameterMap;
import org.springframework.util.MultiValueMap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Roy Clarkson
 */
public class TendrilWebOAuthActivity extends AbstractWebViewActivity {

	private static final String TAG = TendrilWebOAuthActivity.class
			.getSimpleName();
	private String redirectURI;
	private ConnectionRepository connectionRepository;
	private TendrilConnectionFactory connectionFactory;

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// getWebView().getSettings();

		// Using a custom web view client to capture the access token
		// getWebView().setWebViewClient(new TendrilOAuthWebViewClient());

		this.connectionRepository = getApplicationContext()
				.getConnectionRepository();
		this.connectionFactory = getApplicationContext()
				.getTendrilConnectionFactory();
		redirectURI = getString(R.string.tendril_oauth_callback_url);

	}

	@Override
	public void onStart() {
		super.onStart();

		Uri uri = getIntent().getData();
		if (uri != null) {
			System.err.println(uri);
			if (uri.getQueryParameters("access_token") != null)
				displayTendrilOptions();

			String code = uri.getQueryParameter("code");

			if (code != null) {
				
				MultiValueMap<String, String> params = new OAuth2Parameters();
				// String tendrilActivityURL =
				// getString(R.string.tendril_activity);
				
				//FIXME: this doesn't work because Tendril uses a GET for the access token, 
				// and the spec (and spring) use a POST.. 
				// implement subclass of OAuth2Template to fix this..
				AccessGrant accessGrant = connectionFactory
						.getOAuthOperations().exchangeForAccess(code,
								redirectURI, params);

				// AccessGrant accessGrant = new AccessGrant(accessToken);
				Connection<Tendril> connection = connectionFactory
						.createConnection(accessGrant);

				try {
					connectionRepository.addConnection(connection);
				} catch (DuplicateConnectionException e) {
					// connection already exists in repository!
				}

				//displayTendrilOptions();
			}
		} else {
			getWebView().clearView();
			// display the Tendril authorization page
			getWebView().loadUrl(getAuthorizeUrl());
		}

	}

	// ***************************************
	// Private methods
	// ***************************************
	private String getAuthorizeUrl() {
		// String redirectUri = getString(R.string.tendril_oauth_callback_url);
		// String scope = getString(R.string.tendril_scope);
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(redirectURI);
		// params.add("state", "colorado");
		String url = connectionFactory.getOAuthOperations().buildAuthorizeUrl(
				GrantType.AUTHORIZATION_CODE, params);

		return url;
	}

	private void displayTendrilOptions() {
		Intent intent = new Intent();
		intent.setClass(this, TendrilActivity.class);
		startActivity(intent);
		finish();
	}

	// ***************************************
	// Private classes
	// ***************************************
	// private class TendrilOAuthWebViewClient extends WebViewClient {
	//
	// /*
	// * The WebViewClient has another method called shouldOverridUrlLoading
	// * which does not capture the javascript redirect to the success page.
	// * So we're using onPageStarted to capture the url.
	// */
	// @Override
	// public void onPageStarted(WebView view, String url, Bitmap favicon) {
	// // parse the captured url
	// Uri uri = Uri.parse(url);
	//
	// Log.d(TAG, url);
	//
	// /*
	// * The access token is returned in the URI fragment of the URL See
	// * the Desktop Apps section all the way at the bottom of this link:
	// * http://developers.tendril.com/docs/authentication/
	// *
	// * The fragment will be formatted like this:
	// *
	// * #access_token=A&expires_in=0
	// */
	// String uriFragment = uri.getFragment();
	//
	// // confirm we have the fragment, and it has an access_token
	// // parameter
	// if (uriFragment != null && uriFragment.startsWith("code=")) {
	//
	// /*
	// * The fragment also contains an "expires_in" parameter. In this
	// * example we requested the offline_access permission, which
	// * basically means the access will not expire, so we're ignoring
	// * it here
	// */
	// try {
	// // split to get the two different parameters
	// String[] params = uriFragment.split("&");
	//
	// // split to get the access token parameter and value
	// String[] accessTokenParam = params[0].split("=");
	//
	// // get the access token value
	// String accessToken = accessTokenParam[1];
	//
	// // create the connection and persist it to the repository
	// AccessGrant accessGrant = new AccessGrant(accessToken);
	// Connection<Tendril> connection = connectionFactory
	// .createConnection(accessGrant);
	//
	// try {
	// connectionRepository.addConnection(connection);
	// } catch (DuplicateConnectionException e) {
	// // connection already exists in repository!
	// }
	// } catch (Exception e) {
	// // don't do anything if the parameters are not what is
	// // expected
	// }
	//
	// displayTendrilOptions();
	// }
	//
	// /*
	// * if there was an error with the oauth process, return the error
	// * description
	// *
	// * The error query string will look like this:
	// *
	// * ?error_reason=user_denied&error=access_denied&error_description=The
	// * +user+denied+your+request
	// */
	// if (uri.getQueryParameter("error") != null) {
	// CharSequence errorReason = uri.getQueryParameter(
	// "error_description").replace("+", " ");
	// Toast.makeText(getApplicationContext(), errorReason,
	// Toast.LENGTH_LONG).show();
	// displayTendrilOptions();
	// }
	// }
	// }

}
