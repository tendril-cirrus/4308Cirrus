package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import edu.colorado.cs.cirrus.android.task.PricingProgramTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PricingProgramActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = PricingProgramActivity.class.getSimpleName();


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
			String program = "empty";
			try {
				program = (new PricingProgramTask()).execute(tendril).get();
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.setText(program);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String profile = new UserProfileTask().execute("").get();
			System.err.println(program);

			// String profile = task.execute();
		} else {
			Toast.makeText(getApplicationContext(), "Not Connected!",
					Toast.LENGTH_SHORT).show();
		}
	}

	private boolean isConnected() {
		return true;	}
}
