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
		setContentView(R.layout.tendril_get_thermostat_data_layout);

	}

	@Override
	public void onStart() {
		super.onStart();

		GetThermostatDataRequest gtdr = null;
		try {
			//stdr = (new SetThermostatTask()).execute(tendril).get();
			gtdr = tendril.asyncGetThermostatData();
			TextView therm_device_id = (TextView) findViewById(R.id.thermostat_device_id);
			TextView therm_mode = (TextView) findViewById(R.id.thermostat_mode);
			TextView therm_setpoint = (TextView) findViewById(R.id.thermostat_setpoint);
			TextView therm_current_temp = (TextView) findViewById(R.id.thermostat_current_temp);
			
			therm_device_id.setText(gtdr.getDeviceId().toString());
			therm_mode.setText(gtdr.getResult().getMode().toString());
			therm_setpoint.setText(gtdr.getResult().getSetpoint());
			therm_current_temp.setText(gtdr.getResult().getCurrentTemp());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(gtdr);

		// String profile = task.execute();

	}

}
