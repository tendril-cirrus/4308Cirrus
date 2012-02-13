package org.springframework.android.showcase.tendril;

import org.springframework.android.showcase.AbstractAsyncActivity;
import org.springframework.android.showcase.R;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TendrilActivity extends AbstractAsyncActivity {

	protected static final String TAG = TendrilActivity.class.getSimpleName();

	private ConnectionRepository connectionRepository;

	private TendrilConnectionFactory connectionFactory;

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_activity_layout);
		connectionRepository = getApplicationContext()
				.getConnectionRepository();
		connectionFactory = getApplicationContext()
				.getTendrilConnectionFactory();
	}

	@Override
	public void onStart() {
		super.onStart();

		if (isConnected()) {
			System.err.println("Is Connected");
			showTendrilOptions();
		} else {
			showConnectOption();
		}
	}

	// ***************************************
	// Private methods
	// ***************************************
	private boolean isConnected() {
		return connectionRepository.findPrimaryConnection(Tendril.class) != null;
	}

	private void disconnect() {
		connectionRepository.removeConnections(connectionFactory
				.getProviderId());
	}

	private void showConnectOption() {
		String[] options = { "Connect" };
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
					displayTendrilAuthorization();
					break;
				default:
					break;
				}
			}
		});
	}

	private void showTendrilOptions() {
		String[] options = { "Disconnect", "Get User Profile", "Get Device List", "Get Pricing Schedule" };
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
					disconnect();
					showConnectOption();
					break;
				case 1:
					startActivity(new Intent(parentView.getContext(), UserInfoActivity.class));
					break;
				case 2:
					startActivity(new Intent(parentView.getContext(), DeviceListActivity.class));
					break;
				case 3:
					startActivity(new Intent(parentView.getContext(), PricingScheduleActivity.class));
					break;
				default:
					break;
				}
			}
		});
	}

	private void displayTendrilAuthorization() {
		startActivity(new Intent(this, TendrilWebOAuthActivity.class));
		finish();
	}

}
