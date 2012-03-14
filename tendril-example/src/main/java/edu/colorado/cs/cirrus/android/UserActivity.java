package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import edu.colorado.cs.cirrus.android.task.UserTask;
import edu.colorado.cs.cirrus.domain.model.User;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = UserActivity.class.getSimpleName();

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.tendril_userprofile_layout);
	}

	@Override
	public void onStart() {
		super.onStart();

		User user = null;
		try {
			//user = (new UserTask()).execute(tendril).get();
			user=tendril.asyncGetUser();
			
			TextView username = (TextView) findViewById(R.id.user_profile_username);
			username.setText(user.getUserName().toString());
			
			TextView nameFirstLast = (TextView) findViewById(R.id.user_profile_name);
			nameFirstLast.setText(user.getFirstName()+ " " +user.getLastName());
			
			TextView userEmail = (TextView) findViewById(R.id.user_profile_email);
			userEmail.setText(user.getEmailAddress());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(user);
	}
}
