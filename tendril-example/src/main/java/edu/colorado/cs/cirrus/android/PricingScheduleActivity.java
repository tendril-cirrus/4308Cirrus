package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.PricingScheduleTask;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PricingScheduleActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = PricingScheduleActivity.class
			.getSimpleName();

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_pricingschedule_layout);

	}

	@Override
	public void onStart() {
		super.onStart();

		PricingSchedule schedule = null;
		try {
			//schedule = (new PricingScheduleTask()).execute(tendril).get();
			
			DateTime startDate = new DateTime().withDate(2012, 3, 1).withTimeAtStartOfDay();
			DateTime endDate = new DateTime().withDate(2012, 3, 31).withTimeAtStartOfDay();
			
			
			schedule = tendril.fetchPricingSchedule(startDate, endDate);
			
			TextView test = (TextView) findViewById(R.id.textView1);
			TextView accountID = (TextView) findViewById(R.id.pricingschedule_accountid);
			TextView effectiveDate = (TextView) findViewById(R.id.pricingschedule_effective_date);
			TextView programName = (TextView) findViewById(R.id.pricingschedule_programname);
			TextView rateKey = (TextView) findViewById(R.id.pricingschedule_rate_key);
			TextView energyPrice = (TextView) findViewById(R.id.pricingschedule_energy_price);
			
			test.setText(schedule.getEffectivePriceRecords().toString());
			accountID.setText(schedule.getAccountId().toString());
			effectiveDate.setText(schedule.getEffectivePriceRecords().get(0).getEffectiveDate().toString());
			programName.setText(schedule.getEffectivePriceRecords().get(0).getProgramName().toString());
			rateKey.setText(schedule.getEffectivePriceRecords().get(0).getRateKey().toString());
			energyPrice.setText(schedule.getEffectivePriceRecords().get(0).getEnergyPrice().toString());


		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(schedule);

		// String profile = task.execute();

	}

}
