package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

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
		setContentView(R.layout.tendril_generic_text_layout);

	}

	@Override
	public void onStart() {
		super.onStart();

		PricingSchedule schedule = null;
		try {
			//schedule = (new PricingScheduleTask()).execute(tendril).get();
			schedule = tendril.asyncGetPricingSchedule();
			TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText(schedule.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(schedule);

		// String profile = task.execute();

	}

}
