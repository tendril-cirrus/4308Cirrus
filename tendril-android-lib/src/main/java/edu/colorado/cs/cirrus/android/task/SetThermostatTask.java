package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

import android.os.AsyncTask;

public class SetThermostatTask extends
		AsyncTask<TendrilTemplate, Void, SetThermostatDataRequest> {

	@Override
	protected SetThermostatDataRequest doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = params[0];
			if (tendril.isConnected())
				return tendril.setTstatSetpoint(81.0f);

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}