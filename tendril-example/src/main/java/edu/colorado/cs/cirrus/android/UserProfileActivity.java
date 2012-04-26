package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.android.task.UserProfileTask;

import edu.colorado.cs.cirrus.domain.model.UserProfile;

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
		TextView textView= (TextView) findViewById(R.id.textView1);
		try {
			//profile=tendril.asyncGetUserProfile();
			
			this.showLoadingProgressDialog();
			profile=tendril.fetchUserProfile();
			
			//if(profile != null){
				textView.setText(profile.toString());
			//}else{
			//	textView.setText("NULL profile returned!");
			//}

		}catch (TendrilException e) {
			e.printStackTrace();
			//Toast.makeText(getApplicationContext(), e.getComprehensiveString(), Toast.LENGTH_LONG).show();
			textView.setText(e.getComprehensiveString());
		}finally{
			this.dismissProgressDialog();
		}
		// String profile = new UserProfileTask().execute("").get();
		//System.err.println(profile);
	}
}
