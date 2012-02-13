package org.springframework.android.showcase.tendril;

import java.util.concurrent.ExecutionException;

import org.springframework.android.showcase.AbstractAsyncActivity;
import org.springframework.android.showcase.R;
import org.springframework.android.showcase.tendril.task.PricingScheduleTask;
import org.springframework.android.showcase.tendril.task.UserProfileTask;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PricingScheduleActivity extends AbstractAsyncActivity {
	protected static final String TAG = PricingScheduleActivity.class.getSimpleName();

	private ConnectionRepository connectionRepository;

	private TendrilConnectionFactory connectionFactory;
	private Tendril tendril;

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_generic_text_layout);
		connectionRepository = getApplicationContext()
				.getConnectionRepository();
		connectionFactory = getApplicationContext()
				.getTendrilConnectionFactory();

	}

	@Override
	public void onStart() {
		super.onStart();
		this.tendril = getApplicationContext().getConnectionRepository()
				.findPrimaryConnection(Tendril.class).getApi();

		if (isConnected()) {
			System.err.println("Is Connected..");
			String profile = "empty";
			try {
				profile = (new PricingScheduleTask()).execute(tendril).get();
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.setText(profile);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String profile = new UserProfileTask().execute("").get();
			System.err.println(profile);

			// String profile = task.execute();
		} else {
			Toast.makeText(getApplicationContext(), "Not Connected!",
					Toast.LENGTH_SHORT).show();
		}
	}

	private boolean isConnected() {
		return connectionRepository.findPrimaryConnection(Tendril.class) != null;
	}
}
