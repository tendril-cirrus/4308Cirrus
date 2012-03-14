package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;

import android.os.AsyncTask;

public class PricingProgramTask extends
		AsyncTask<TendrilTemplate, Void, PricingProgram> {

	@Override
	protected PricingProgram doInBackground(TendrilTemplate... params) {
		try {
			TendrilTemplate tendril = TendrilTemplate.get();
			if (tendril.isConnected())
				return tendril.fetchPricingProgram();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}