package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.User;

import android.os.AsyncTask;

public class UserTask extends AsyncTask<TendrilTemplate, Void, User> {

	@Override
	protected User doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.fetchUser();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}