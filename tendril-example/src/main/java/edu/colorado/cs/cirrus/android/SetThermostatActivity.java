package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;

public class SetThermostatActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = SetThermostatActivity.class.getSimpleName();

    Button setButton;
    EditText editTemp;

    TextView thermDeviceId;
    TextView thermRequestId;
    TextView thermMode;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_set_thermostat_layout);
        setButton = (Button) findViewById(R.id.setButton);
        editTemp = (EditText) findViewById(R.id.temperature);

        thermDeviceId = (TextView) findViewById(R.id.thermostat_device_id);
        thermRequestId = (TextView) findViewById(R.id.thermostat_request_id);
        thermMode = (TextView) findViewById(R.id.thermostat_mode);

        thermDeviceId.setText("");
        thermRequestId.setText("");
        editTemp.setText("68");
        thermMode.setText("");

        setButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                SetThermostatDataRequest stdr = null;
                try {
                    showLoadingProgressDialog();
                    stdr = tendril.setTstatSetpoint(Float.parseFloat(editTemp.getEditableText().toString()));

                    thermDeviceId.setText(stdr.getDeviceId());
                    thermRequestId.setText(stdr.getRequestId());
                    editTemp.setText(stdr.getData().getSetpoint());
                    thermMode.setText(stdr.getData().getMode());

                    Toast.makeText(getApplicationContext(),
                            "Thermostat has been set to " + editTemp.getEditableText().toString(), Toast.LENGTH_LONG)
                            .show();

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                finally {
                    dismissProgressDialog();
                }
                System.err.println(stdr);

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
