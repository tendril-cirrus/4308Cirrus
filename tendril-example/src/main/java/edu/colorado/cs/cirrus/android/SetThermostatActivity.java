package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

public class SetThermostatActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = SetThermostatActivity.class.getSimpleName();

    NumberPicker tempPicker;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_set_thermostat_layout);

        tempPicker = (NumberPicker) findViewById(R.id.temperaturePicker);
    }

    @Override
    public void onStart() {
        super.onStart();

        SetThermostatDataRequest stdr = null;
        try {
            this.showLoadingProgressDialog();
            stdr = tendril.setTstatSetpoint(80.0f);

            TextView thermDeviceId = (TextView) findViewById(R.id.thermostat_device_id);
            TextView thermRequestId = (TextView) findViewById(R.id.thermostat_request_id);
            TextView thermSetPoint = (TextView) findViewById(R.id.thermostat_setpoint);
            TextView thermMode = (TextView) findViewById(R.id.thermostat_mode);

            thermDeviceId.setText(stdr.getDeviceId());
            thermRequestId.setText(stdr.getRequestId());
            thermSetPoint.setText(stdr.getData().getSetpoint());
            thermMode.setText(stdr.getData().getMode());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        System.err.println(stdr);
    }

}
