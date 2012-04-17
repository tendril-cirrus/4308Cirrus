package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.Device;
import edu.colorado.cs.cirrus.domain.model.Devices;

public class DeviceDetailActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = DevicesActivity.class.getSimpleName();

	// private ConnectionRepository connectionRepository;
	//
	// private TendrilConnectionFactory connectionFactory;
	// private Tendril tendril;

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_device_detail_layout);

	}

	@Override
	public void onStart() {

		super.onStart();

		Devices devices = null;
		Bundle bundle = this.getIntent().getExtras();
		int deviceNumber = 0;
		deviceNumber = bundle.getInt("deviceID");
		
		try {
			//devices = (new DevicesTask()).execute(tendril).get();
			//devices=tendril.asyncGetDevices();
			this.showLoadingProgressDialog();
			devices=tendril.fetchDevices();
			
			Device targetDevice = devices.getDevice().get(deviceNumber);
			
			TextView deviceName = (TextView) findViewById(R.id.device_name);
			deviceName.setText(targetDevice.getName());
			
			TextView deviceID = (TextView) findViewById(R.id.device_id);
			deviceID.setText(targetDevice.getDeviceId());
			
			TextView marketingName = (TextView) findViewById(R.id.device_marketing_name);
			marketingName.setText(targetDevice.getMarketingName());
			
			TextView networkID = (TextView) findViewById(R.id.device_network_id);
			networkID.setText(targetDevice.getNetworkId());
			
			

		}catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
		}finally{
			this.dismissProgressDialog();
		}
		//System.err.println(devices.toString());

	}

	private boolean isConnected() {
		return true;
	}
}
