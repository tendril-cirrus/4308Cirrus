package edu.colorado.cs.cirrus.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockPreferenceActivity;

public class CirrusPreferenceActivity extends SherlockPreferenceActivity {

    private SharedPreferences customCirrusPrefs;

    private Preference setHomeLocPref;
    private Preference gpsFreqPref;
    private Preference smartHeatPref;
    private Preference logoutPref;


    private EditTextPreference homeTempPref;
    private EditTextPreference awayTempPref;

    private LocationManager locManager;
    private LocationListener locListener;

    private simplePreferenceClickListener myPreferenceClickListener;

    private double latitude = 0.0;
    private double longitude = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Setup layout
        addPreferencesFromResource(R.xml.preferences);

        //On click listener
        myPreferenceClickListener = new simplePreferenceClickListener();
        
        //Attach to the Preferences from the layout
        setHomeLocPref = (Preference) findPreference("setHomeLocPref");
        gpsFreqPref = (Preference) findPreference("gpsFreqPref");
        smartHeatPref = (Preference) findPreference("smartHeat");
        homeTempPref = (EditTextPreference) findPreference("homeTemp");
        awayTempPref = (EditTextPreference) findPreference("awayTemp");
        logoutPref = (Preference) findPreference("logout");

        //Set on click listener
        setHomeLocPref.setOnPreferenceClickListener(myPreferenceClickListener);
        gpsFreqPref.setOnPreferenceClickListener(myPreferenceClickListener);
        smartHeatPref.setOnPreferenceClickListener(myPreferenceClickListener);
        homeTempPref.setOnPreferenceClickListener(myPreferenceClickListener);
        awayTempPref.setOnPreferenceClickListener(myPreferenceClickListener);
        logoutPref.setOnPreferenceClickListener(myPreferenceClickListener);


        // Force homeTempPref and awayTempPref to take numbers
        EditText homeTempEditText = (EditText)homeTempPref.getEditText();
        homeTempEditText.setKeyListener(DigitsKeyListener.
                getInstance(false,true));

        EditText awayTempEditText = (EditText)awayTempPref.getEditText();
        awayTempEditText.setKeyListener(DigitsKeyListener.
                getInstance(false,true));

        // Setup the location stuff
        locManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);

        locListener = new MyLocationListener();


    }


    @Override
    protected void onResume() {
        super.onResume();

        //Do work for restoring saved prefs
        customCirrusPrefs = getSharedPreferences(                                                "customCirrusPrefs", Activity.MODE_PRIVATE);

        //Start polling for GPS information every 2 seconds
        locManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 2000, 0, locListener);


    }

    @Override
    protected void onPause() {
        //Stop polling for GPS info
        locManager.removeUpdates(locListener);

        super.onPause();

    }



    class simplePreferenceClickListener implements OnPreferenceClickListener{

        public boolean onPreferenceClick(Preference preference) {

            // Get ready to edit the saved preferences
            SharedPreferences.Editor editor = customCirrusPrefs.edit();               

            if ( preference.equals(setHomeLocPref) ){
                Toast.makeText(getBaseContext(), "Setting home location",
                    Toast.LENGTH_SHORT).show();

                if( latitude == 0.0 || longitude == 0.0 ){
                    Toast.makeText(getBaseContext(), "Error getting GPS info",
                        Toast.LENGTH_LONG).show();
                    return false;
                }

                editor.putFloat("homeLatitude", (float) latitude);
                editor.putFloat("homeLongitude", (float) longitude);
    
                Toast.makeText(getBaseContext(), "Latitude: " + latitude
                        + ", Longitude: " + longitude,
                        Toast.LENGTH_SHORT).show();

            } else if (preference.equals(logoutPref)) {
                editor.remove("accessToken");
                finish();
            }

            //Actually do the saving
            return editor.commit();
        }

    }

    class MyLocationListener implements LocationListener {
        public void onLocationChanged(Location loc) {
            //Just update latitude and longitude
            latitude = loc.getLatitude();
            longitude = loc.getLongitude();
        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getBaseContext(), "GPS Disabled", 
                Toast.LENGTH_SHORT).show();

        }

        
        public void onProviderEnabled(String provider) {
            Toast.makeText(getBaseContext(), "GPS Enabled", 
                Toast.LENGTH_SHORT).show();

        }

        public void onStatusChanged(String provider, int status,
                Bundle extras) {


        }
    }


}

