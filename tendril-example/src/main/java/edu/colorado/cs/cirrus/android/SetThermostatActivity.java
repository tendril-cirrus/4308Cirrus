package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.PricingScheduleTask;
import edu.colorado.cs.cirrus.android.task.SetThermostatTask;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SetThermostatActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = SetThermostatActivity.class
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

		SetThermostatDataRequest stdr = null;
		try {
			stdr = tendril.asyncSetThermostat();
			TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText(stdr.toString());

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(stdr);

		// String profile = task.execute();

	}

}
