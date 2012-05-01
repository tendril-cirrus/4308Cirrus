package edu.colorado.cs.cirrus.cirrus;

import org.joda.time.DateTime;
import edu.colorado.cs.cirrus.android.*;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.Resolution;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;
import edu.colorado.cs.cirrus.domain.model.fetchThermostatDataRequest;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CirrusActivity extends AbstractAsyncTendrilActivity implements
        ActionBar.TabListener {
	
	private LinearLayout costLayout;
	private LinearLayout consumptionLayout;
	private LinearLayout thermostatLayout;
	
	private ActionBar.Tab costTab;
	private ActionBar.Tab consumptionTab;
	private ActionBar.Tab thermostatTab;
	
	private TextView smartHeatText;
	private TextView modeText;
	private EditText setpointText;
	private TextView currentTempText;
	
	private Button setThermostatButton;
	private Button refreshButton;
	
	private DateTime startOf2011 = new DateTime();
	private DateTime endOf2011 = new DateTime();
	
	private PreferenceUtils cirrusPrefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		startOf2011 = startOf2011.withYear(2011).withMonthOfYear(1)
		        .withDayOfMonth(1).withTimeAtStartOfDay();
		endOf2011 = endOf2011.withYear(2012).withMonthOfYear(1)
		        .withDayOfMonth(1).withTimeAtStartOfDay().minusMillis(1);
		
		cirrusPrefs = new PreferenceUtils(this);
		
		tendril = TendrilTemplate.get();
		
		// Grab layouts
		setContentView(R.layout.cirrus_all_layout);
		costLayout = (LinearLayout) findViewById(R.id.cost);
		consumptionLayout = (LinearLayout) findViewById(R.id.consumption);
		thermostatLayout = (LinearLayout) findViewById(R.id.thermostat);
		modeText = (TextView) findViewById(R.id.thermostat_mode);
		setpointText = (EditText) findViewById(R.id.thermostat_setpoint);
		currentTempText = (TextView) findViewById(R.id.thermostat_current_temp);
		smartHeatText = (TextView) findViewById(R.id.thermostat_smart_heat);
		
		setThermostatButton = (Button) findViewById(R.id.setButton);
		refreshButton = (Button) findViewById(R.id.refreshButton);
		
		// Force changing the setpoint to take numbers
		setpointText.setKeyListener(DigitsKeyListener.getInstance(false, true));
		
		// Hide the keyboard when enter is pressed
		setpointText.setOnKeyListener(new View.OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
					InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					if(mgr != null){
						mgr.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
						return true;
					}
				}
				return false;
			}
		});
		
		// Setup actionbar
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// costTab setup
		costTab = getSupportActionBar().newTab();
		costTab.setText("$$$");
		costTab.setTabListener(this);
		getSupportActionBar().addTab(costTab);
		
		// consumptionTab setup
		consumptionTab = getSupportActionBar().newTab();
		consumptionTab.setText("kWh");
		consumptionTab.setTabListener(this);
		getSupportActionBar().addTab(consumptionTab);
		
		// thermostatTab setup
		thermostatTab = getSupportActionBar().newTab();
		thermostatTab.setText("\u00B0F");
		thermostatTab.setTabListener(this);
		getSupportActionBar().addTab(thermostatTab);
		
		// Set on click listener for buttons
		setThermostatButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				showLoadingProgressDialog();
				try {
					SetThermostatDataRequest stdr = tendril
					        .setTstatSetpoint(Float.parseFloat(setpointText
					                .getEditableText().toString()));
					modeText.setText(stdr.getData().getMode());
					setpointText.setText(stdr.getData().getSetpoint());
					cirrusPrefs.setSmartHeat(false);
					smartHeatText.setText("Disabled");
					
					dismissProgressDialog();
					
					ToastFactory
					        .showToast(getApplicationContext(),
					                "Thermostat has been set to "
					                        + setpointText.getEditableText()
					                                .toString());
					
				} catch (TendrilException e) {
					ToastFactory.showToast(getApplicationContext(), e
					        .getTendrilResponse().getReason());
					Log.e(TAG, e.getTendrilResponse().toString());
				} catch (Exception e) {
					ToastFactory.showToast(getApplicationContext(),
					        "Something went horribly wrong...");
				}
				
				finally {
					dismissProgressDialog();
				
				}
				
			}
		});
		
		refreshButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				thermostatTab.select();
			}
		});
		
		// Set Consumption Layout as default
		consumptionTab.select();
		
		// Start the background service
		startService(new Intent(this, TendrilLocationService.class));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		tendril.useAccessToken(cirrusPrefs.getAccessToken());
	}
	
	public void onTabReselected(Tab tab, FragmentTransaction transaction) {
	}
	
	public void onTabSelected(Tab tab, FragmentTransaction transaction) {
		// Make all Layouts invisible
		// 8 visibility = gone
		// 4 visibility = invisible
		// 0 visibility = visible
		costLayout.setVisibility(8);
		consumptionLayout.setVisibility(8);
		thermostatLayout.setVisibility(8);
		
		showLoadingProgressDialog();
		// Determine which layout to make visible
		try {
			if (tab.equals(costTab)) {
				costLayout.setVisibility(0);
				
				CostAndConsumption CnC = tendril.fetchCostAndConsumption(
				        Resolution.MONTHLY, startOf2011, endOf2011, 12);
				costLayout.addView(BarGraph.getYearlyCostView(this,
				        CnC.getComponentList(), "Energy Costs for 2011"));
				
			} else if (tab.equals(consumptionTab)) {
				consumptionLayout.setVisibility(0);
				
				CostAndConsumption CnC = tendril.fetchCostAndConsumption(
				        Resolution.MONTHLY, startOf2011, endOf2011, 12);
				consumptionLayout.addView(BarGraph.getYearlyConsumptionView(
				        this, CnC.getComponentList(),
				        "Energy Consumption for 2011"));
				
			} else if (tab.equals(thermostatTab)) {
				thermostatLayout.setVisibility(0);
				
				fetchThermostatDataRequest gtdr = tendril.getThermostatData();
				
				modeText.setText(gtdr.getResult().getMode().toString());
				setpointText.setText(gtdr.getResult().getSetpoint());
				currentTempText.setText(gtdr.getResult().getCurrentTemp());
				if (cirrusPrefs.getSmartHeat() == true)
					smartHeatText.setText("Enabled");
				else
					smartHeatText.setText("Disabled");
				
			}
		} catch (TendrilException e) {
			ToastFactory.showToast(this, e.getTendrilResponse().getReason());
			Log.e(TAG, e.getTendrilResponse().toString());
		} catch (Exception e) {
			ToastFactory.showToast(this, "Something went horribly wrong...");
		}
		
		dismissProgressDialog();
	}
	
	public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
		// Stop any async tasks.... If we can even do that
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Add icon for getting to the settings menu
		menu.add("Settings").setIcon(R.drawable.settingsicon)
		        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Open the settings activity
		if (item.getTitle() == "Settings") {
			Intent intent = new Intent(this, CirrusPreferenceActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivityForResult(intent, 0);
			return true;
			
		}
		return false;
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == -1) {
				// We are logged out, return to main menu
				finish();
			}
		}
		
	}
	
}
