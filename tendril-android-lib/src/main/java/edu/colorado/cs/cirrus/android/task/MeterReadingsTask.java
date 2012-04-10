package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.MeterReading;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.MeterReadings;
import edu.colorado.cs.cirrus.domain.model.User;

import android.os.AsyncTask;

public class MeterReadingsTask extends AsyncTask<TendrilTemplate, Void, MeterReadings> {

	@Override
	protected MeterReadings doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.fetchMeterReadingsRange(new DateTime("2012-03-01T00:00:00-07:00"), (new DateTime()).minusDays(1));

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}
