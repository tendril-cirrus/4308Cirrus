package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.User;

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
            this.showLoadingProgressDialog();
            user = tendril.fetchUser();

            TextView username = (TextView) findViewById(R.id.user_profile_username);
            username.setText(user.getUserName().toString());

            TextView nameFirstLast = (TextView) findViewById(R.id.user_profile_name);
            nameFirstLast.setText(user.getFirstName() + " " + user.getLastName());

            TextView userEmail = (TextView) findViewById(R.id.user_profile_email);
            userEmail.setText(user.getEmailAddress());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        System.err.println(user);
    }
}
