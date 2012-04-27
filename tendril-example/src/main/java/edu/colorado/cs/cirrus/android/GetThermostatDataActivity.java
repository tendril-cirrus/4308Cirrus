package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.fetchThermostatDataRequest;

public class GetThermostatDataActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = GetThermostatDataActivity.class.getSimpleName();

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_get_thermostat_data_layout);

    }

    @Override
    public void onStart() {
        super.onStart();

        fetchThermostatDataRequest gtdr = null;
        try {
            this.showLoadingProgressDialog();
            gtdr = tendril.getThermostatData();

            TextView therm_device_id = (TextView) findViewById(R.id.thermostat_device_id);
            TextView therm_mode = (TextView) findViewById(R.id.thermostat_mode);
            TextView therm_setpoint = (TextView) findViewById(R.id.thermostat_setpoint);
            TextView therm_current_temp = (TextView) findViewById(R.id.thermostat_current_temp);

            therm_device_id.setText(gtdr.getDeviceId().toString());
            therm_mode.setText(gtdr.getResult().getMode().toString());
            therm_setpoint.setText(gtdr.getResult().getSetpoint());
            therm_current_temp.setText(gtdr.getResult().getCurrentTemp());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        System.err.println(gtdr);
    }

}
