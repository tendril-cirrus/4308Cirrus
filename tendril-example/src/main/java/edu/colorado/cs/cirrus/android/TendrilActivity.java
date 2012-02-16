package edu.colorado.cs.cirrus.android;

import edu.colorado.cs.cirrus.domain.intf.ITendril;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TendrilActivity extends Activity {

    private static String TAG = "tendril-example";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart(){
    	ITendril tendril = new TendrilTemplate("csci4138@tendrilinc.com", "password");
    	
    	
    }

}

