package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.GetThermostatDataRequest;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

import android.os.AsyncTask;

public class GetThermostatDataTask extends
		AsyncTask<TendrilTemplate, Void, String> {

	@Override
	protected String doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.getThermostatData();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}