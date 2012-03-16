package edu.colorado.cs.cirrus.android.task;

import android.os.AsyncTask;
import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

public class UserProfileTask extends AsyncTask<TendrilTemplate, Void, UserProfile> {
	@Override
	protected UserProfile doInBackground(TendrilTemplate... params) {

		TendrilTemplate tendril = TendrilTemplate.get();
		if (tendril.isConnected()){
			return tendril.fetchUserProfile();
		}
		
		//System.err.println("UserProfileTask returning NULL (not logged in)!");
		return null;
	}
}
