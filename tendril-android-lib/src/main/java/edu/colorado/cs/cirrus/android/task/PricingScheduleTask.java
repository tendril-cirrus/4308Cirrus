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
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.fetchPricingSchedule(new DateTime("2011-03-02T00:00:00-07:00"), new DateTime("2011-12-31T00:00:00-07:00"));

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}