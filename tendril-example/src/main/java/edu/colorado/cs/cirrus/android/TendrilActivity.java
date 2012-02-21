package edu.colorado.cs.cirrus.android;

//import edu.colorado.cs.cirrus.domain.intf.ITendril;
import org.joda.time.DateTime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TendrilActivity extends Activity {

	
	protected static final String TAG = TendrilActivity.class.getSimpleName();

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
		setContentView(R.layout.tendril_activity_layout);
        //setContentView(R.layout.main);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	TendrilTemplate tendril = ((TendrilApplication) getApplication()).getTendril();
    	
    	showTendrilOptions();
    	//tendril.fetchUser();
    	//tendril.fetchDevices();
    	//System.err.println(tendril.fetchPricingProgram());
    	//System.err.println(tendril.fetchPricingSchedule((new DateTime()).minusMonths(12), new DateTime()));
    }
    
    private void showTendrilOptions() {
		String[] options = { "Get User Profile", "Get Device List", "Get Pricing Program" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, options);
		ListView listView = (ListView) this
				.findViewById(R.id.tendril_activity_options_list);
		listView.setAdapter(arrayAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentView, View childView,
					int position, long id) {
				switch (position) {
				
				case 0:
					startActivity(new Intent(parentView.getContext(), UserActivity.class));
					break;
				case 1:
					startActivity(new Intent(parentView.getContext(), DevicesActivity.class));
					break;
				case 2:
					startActivity(new Intent(parentView.getContext(), PricingProgramActivity.class));
					break;
				default:
					break;
				}
			}
		});
	}

}

