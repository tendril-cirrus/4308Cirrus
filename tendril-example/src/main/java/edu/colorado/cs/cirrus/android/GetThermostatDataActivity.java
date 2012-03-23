package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.PricingScheduleTask;
import edu.colorado.cs.cirrus.android.task.SetThermostatTask;
import edu.colorado.cs.cirrus.domain.model.GetThermostatDataRequest;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GetThermostatDataActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = GetThermostatDataActivity.class
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

		GetThermostatDataRequest gtdr = null;
		try {
			//stdr = (new SetThermostatTask()).execute(tendril).get();
			//gtdr = tendril.asyncGetThermostatData();
			TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText(tendril.asyncGetThermostatData().toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(gtdr);

		// String profile = task.execute();

	}

}
