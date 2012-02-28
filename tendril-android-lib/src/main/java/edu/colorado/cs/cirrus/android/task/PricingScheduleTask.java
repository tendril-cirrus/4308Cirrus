package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;

import android.os.AsyncTask;

public class PricingScheduleTask extends
		AsyncTask<TendrilTemplate, Void, PricingSchedule> {

	@Override
	protected PricingSchedule doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = params[0];
			if (tendril.isConnected())
				return tendril.fetchPricingSchedule(null, null);

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}