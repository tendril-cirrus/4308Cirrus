package edu.colorado.cs.cirrus.android;

import android.content.Context;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.preference.ListPreference;
import android.preference.PreferenceManager;

import edu.colorado.cs.cirrus.android.R;

import android.app.Activity;

import android.content.SharedPreferences;

import android.os.Bundle;

import android.preference.Preference;

import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

import android.widget.Toast;

public class CirrusPreferenceActivity extends PreferenceActivity {

    private SharedPreferences customCirrusPrefs;

    private Preference setHomeLocPref;
    private Preference gpsFreqPref;

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

        //Set on click listener
        setHomeLocPref.setOnPreferenceClickListener(myPreferenceClickListener);

        // Setup the location stuff
        locManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);

        locListener = new MyLocationListener();


    }


    @Override
    protected void onResume() {
        super.onResume();

        //Do work for restoring saved prefs
        //getPrefs();
        
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

            } else if ( preference.equals(gpsFreqPref) ) {

                editor.putString("gpsFreq", gpsFreqPref.getKey());

                Toast.makeText(getBaseContext(), "gpsFreq: " 
                        + gpsFreqPref.getKey(), Toast.LENGTH_SHORT).show();
            }

            //Actually do the saving
            return editor.commit();
        }

    }

    class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            //Just update latitude and longitude
            latitude = loc.getLatitude();
            longitude = loc.getLongitude();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getBaseContext(), "GPS Disabled", 
                Toast.LENGTH_SHORT).show();

        }

        
        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(getBaseContext(), "GPS Enabled", 
                Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onStatusChanged(String provider, int status,
                Bundle extras) {


        }
    }


}

