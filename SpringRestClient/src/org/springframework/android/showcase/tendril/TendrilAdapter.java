package org.springframework.android.showcase.tendril;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;

public class TendrilAdapter implements ApiAdapter<Tendril> {
	public boolean test(Tendril api) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setConnectionValues(Tendril api, ConnectionValues values) {
		// TODO Auto-generated method stub
		
	}

	public UserProfile fetchUserProfile(Tendril api) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStatus(Tendril api, String message) {
		// TODO Auto-generated method stub
		
	}
	
}