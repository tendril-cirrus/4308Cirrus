package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.MeterReading;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.User;

import android.os.AsyncTask;

public class MeterReadingTask extends AsyncTask<TendrilTemplate, Void, MeterReading> {

	@Override
	protected MeterReading doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.fetchMeterReadingRange(new DateTime("2011-01-01T00:00:00-07:00"), (new DateTime()).minusDays(1));

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}
