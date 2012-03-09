package edu.colorado.cs.cirrus.android.task;

import android.os.AsyncTask;
import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

public class UserProfileTask extends AsyncTask<TendrilTemplate, Void, UserProfile> {
	@Override
	protected UserProfile doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = params[0];
			if (tendril.isConnected())
				return tendril.fetchUserProfile();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}
		
		System.err.println("UserProfileTask returning NULL (not logged in)!");
		return null;
	}
}
