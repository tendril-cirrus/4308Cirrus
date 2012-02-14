package org.springframework.android.showcase.tendril.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.android.showcase.R;
import org.springframework.android.showcase.rest.State;
import org.springframework.android.showcase.tendril.Tendril;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.web.client.RestTemplate;

import android.os.AsyncTask;
import android.util.Log;

public class PricingScheduleTask extends AsyncTask<Tendril, Void, String> {

	@Override
	protected String doInBackground(Tendril... params) {
		try {
			return params[0].fetchPricingSchedule((new DateTime()).minusYears(2), new DateTime());

		} catch (Exception e) {
			e.printStackTrace();
			// Log.e(TAG, e.getMessage(), e);
		}

		return null;
	}

}