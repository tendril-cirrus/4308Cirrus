package edu.colorado.cs.cirrus.android;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.colorado.cs.cirrus.domain.model.Device;
import edu.colorado.cs.cirrus.domain.model.Devices;

public class DevicesActivity extends AbstractAsyncTendrilActivity {
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
		setContentView(R.layout.tendril_device_list_layout);

	}

	@Override
	public void onStart() {

		super.onStart();

		Devices devices = null;
		try {
			//devices = (new DevicesTask()).execute(tendril).get();
			devices=tendril.asyncGetDevices();
			
			
			ListView devicesList = (ListView) findViewById(R.id.devicesList);
			List<String> deviceNameList = new ArrayList<String>();
			for (Device d : devices.getDevice()){
				deviceNameList.add(d.getName());
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, deviceNameList);
			devicesList.setAdapter(adapter);
			
			
			devicesList.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

					Intent deviceDetailIntent = new Intent(DevicesActivity.this, DeviceDetailActivity.class);
					deviceDetailIntent.putExtra("deviceID", position);
					startActivity(deviceDetailIntent);
//					Toast.makeText(getApplicationContext(),
//						"List Item Number: " + (position), Toast.LENGTH_LONG)
//						.show();
				}
			});
			
			
			
//			TextView textView = (TextView) findViewById(R.id.textView1);
//			textView.setText(devices.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(devices.toString());

	}

	private boolean isConnected() {
		return true;
	}
}
