package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.widget.TextView;
import edu.colorado.cs.cirrus.domain.TendrilException;
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
        TextView textView = (TextView) findViewById(R.id.textView1);
        try {
            this.showLoadingProgressDialog();
            profile = tendril.fetchUserProfile();
            textView.setText(profile.toString());
        }
        catch (TendrilException e) {

            e.printStackTrace();
            textView.setText(((TendrilAndroidException) e).getComprehensiveString());
        }
        finally {
            this.dismissProgressDialog();
        }
    }
}
