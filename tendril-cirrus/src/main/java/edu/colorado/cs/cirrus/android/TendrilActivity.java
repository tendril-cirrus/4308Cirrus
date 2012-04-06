package edu.colorado.cs.cirrus.android;

import org.joda.time.DateTime;

import android.content.Context;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;

import android.widget.Button;
import android.widget.LinearLayout;

import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;

//import edu.colorado.cs.cirrus.domain.intf.ITendril;

public class TendrilActivity extends SherlockActivity {
    // public class TendrilActivity extends FragmentActivity {

    private TendrilTemplate tendril;
    private String rememberToken;
    private static SharedPreferences customCirrusPrefs;
    private LinearLayout loginMenu;

    private Button loginButton;
    private Button loginSubmitButton;
    private Button loginCancelButton;


    protected static final String TAG = TendrilActivity.class.getSimpleName();

    /**
     * Called when the activity is first created.
     * 
     * @param savedInstanceState
     *            If the activity is being re-initialized after previously being shut down then this Bundle contains the
     *            data it most recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     * 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        setContentView(R.layout.tendril_activity_layout);
        // setContentView(R.layout.main);
    }

    @Override
    public void onStart() {
        super.onStart();
        // TendrilTemplate tendril = ((TendrilApplication) getApplication()).getTendril();
        tendril = TendrilTemplate.get();


        //Grab layouts and buttons
        loginSubmitButton = (Button) findViewById(R.id.LoginSubmitButton);
        loginCancelButton = (Button) findViewById(R.id.LoginCancelButton);

        loginMenu = (LinearLayout) findViewById(R.id.LoginMenu);


    }

    @Override
    public void onResume() {
        super.onResume();

        customCirrusPrefs = getSharedPreferences("customCirrusPrefs", 
                Activity.MODE_PRIVATE);

        // Recover our rememberToken if set, or null if not set
        rememberToken = customCirrusPrefs.getString("rememberToken", null);
        
        if ( rememberToken == null ){
            //Show login Menu
            // 8 visibility = gone
            // 4 visibility = invisible
            // 0 visibility = visible

            loginMenu.setVisibility(0);

        } else {
            //TODO go to next activity

        }

    }


}
