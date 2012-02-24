package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;


import edu.colorado.cs.cirrus.android.task.DevicesTask;
import edu.colorado.cs.cirrus.domain.model.Devices;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DevicesActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = DevicesActivity.class.getSimpleName();

//	private ConnectionRepository connectionRepository;
//
//	private TendrilConnectionFactory connectionFactory;
//	private Tendril tendril;

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

		if (isConnected()) {
			System.err.println("Is Connected..");
			Devices devices = null;
			try {
				devices = (new DevicesTask()).execute(tendril).get();
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.setText(devices.toString());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String profile = new UserProfileTask().execute("").get();
			System.err.println(devices.toString());

			// String profile = task.execute();
		} else {
			Toast.makeText(getApplicationContext(), "Not Connected!",
					Toast.LENGTH_SHORT).show();
		}
	}

	private boolean isConnected() {
		return true;
	}
}
