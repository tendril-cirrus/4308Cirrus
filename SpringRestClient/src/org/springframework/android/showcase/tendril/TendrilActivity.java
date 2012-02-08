package org.springframework.android.showcase.tendril;

import org.springframework.android.showcase.AbstractAsyncActivity;
import org.springframework.android.showcase.R;
import org.springframework.android.showcase.social.facebook.FacebookActivity;
import org.springframework.android.showcase.social.facebook.FacebookHomeFeedActivity;
import org.springframework.android.showcase.social.facebook.FacebookProfileActivity;
import org.springframework.android.showcase.social.facebook.FacebookWallPostActivity;
import org.springframework.android.showcase.social.facebook.FacebookWebOAuthActivity;
import org.springframework.android.showcase.social.twitter.TwitterActivity;
import org.springframework.android.showcase.social.twitter.TwitterDirectMessageActivity;
import org.springframework.android.showcase.social.twitter.TwitterProfileActivity;
import org.springframework.android.showcase.social.twitter.TwitterTimelineActivity;
import org.springframework.android.showcase.social.twitter.TwitterTweetActivity;
import org.springframework.android.showcase.social.twitter.TwitterWebOAuthActivity;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
		String[] options = { "Disconnect", "Get User Profile" };
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
					//Toast.makeText(getApplicationContext(), "Get User Profile", Toast.LENGTH_LONG).show();
					startActivity(new Intent(parentView.getContext(), UserProfileActivity.class));
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
