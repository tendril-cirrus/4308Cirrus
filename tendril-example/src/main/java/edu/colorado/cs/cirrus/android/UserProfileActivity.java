package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import edu.colorado.cs.cirrus.android.task.UserProfileTask;
import edu.colorado.cs.cirrus.android.task.UserTask;
import edu.colorado.cs.cirrus.domain.model.User;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = UserProfileActivity.class.getSimpleName();

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

		UserProfile profile = null;
		try {
			profile = (new UserProfileTask()).execute(tendril).get();
			TextView textView = (TextView) findViewById(R.id.textView1);
			if(profile != null){
				textView.setText(profile.toString());
			}else{
				textView.setText("NULL profile returned!");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(profile);
	}
}
