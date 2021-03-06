package edu.colorado.cs.cirrus.android;

//import edu.colorado.cs.cirrus.domain.intf.ITendril;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.intf.ITendril;

public class TendrilActivity extends SherlockActivity {
    protected static final String TAG = TendrilActivity.class.getSimpleName();
    private final String USERNAME = "csci4138@tendrilinc.com";
    private final String PASSWORD = "password";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        ITendril tendril = TendrilTemplate.get();
        try {
            tendril.logIn(USERNAME, PASSWORD);
        }
        catch (TendrilException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.tendril_activity_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
        showTendrilOptions();
    }

    private void showTendrilOptions() {
        String[] options = { "Get User Info", "Get User Profile", "Get Device List", "Get Pricing Program",
                "Get Pricing Schedule", "Get Historical Cost and Consumption", "Get Meter Reading Range",
                "Set Thermostat", "Get Thermostat Data", "Preferences" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options);
        ListView listView = (ListView) this.findViewById(R.id.tendril_activity_options_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentView, View childView, int position, long id) {
                switch (position) {

                // Get User
                case 0:
                    startActivity(new Intent(parentView.getContext(), UserActivity.class));
                    break;

                // Get User Profile
                case 1:
                    startActivity(new Intent(parentView.getContext(), UserProfileActivity.class));
                    break;

                // Get Device List
                case 2:
                    startActivity(new Intent(parentView.getContext(), DevicesActivity.class));
                    break;

                // Get Pricing Program
                case 3:
                    startActivity(new Intent(parentView.getContext(), PricingProgramActivity.class));
                    break;

                // Get Pricing Schedule
                case 4:
                    // Toast toast = Toast.makeText(parentView.getContext(), "Not yet implemented", Toast.LENGTH_SHORT);
                    // toast.show();
                    startActivity(new Intent(parentView.getContext(), PricingScheduleActivity.class));
                    break;

                // Get historical cost and consumption
                case 5:
                    // toast = Toast.makeText(parentView.getContext(), "Not yet implemented", Toast.LENGTH_SHORT);
                    // toast.show();
                    startActivity(new Intent(parentView.getContext(), CostAndConsumptionActivity.class));
                    break;

                // Get Meter Reading Range
                case 6:
                    // toast = Toast.makeText(parentView.getContext(), "Not yet implemented", Toast.LENGTH_SHORT);
                    // toast.show();
                    startActivity(new Intent(parentView.getContext(), MeterReadingsActivity.class));
                    break;

                // Set Thermostat to 80
                case 7:
                    startActivity(new Intent(parentView.getContext(), SetThermostatActivity.class));
                    break;
                case 8:
                    startActivity(new Intent(parentView.getContext(), GetThermostatDataActivity.class));
                    break;
                case 9:
                    startActivity(new Intent(parentView.getContext(), CirrusPreferenceActivity.class));
                    break;
                default:
                    break;
                }
            }
        });
    }

}
