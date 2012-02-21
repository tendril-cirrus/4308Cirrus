package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.Devices;

import android.os.AsyncTask;


public class DevicesTask extends AsyncTask<TendrilTemplate, Void, Devices> {

	@Override
	protected Devices doInBackground(TendrilTemplate... params) {
		try {
			return params[0].fetchDevices();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}