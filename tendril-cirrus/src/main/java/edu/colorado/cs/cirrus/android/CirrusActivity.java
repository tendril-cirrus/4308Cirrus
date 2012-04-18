package edu.colorado.cs.cirrus.android;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;

import android.widget.LinearLayout;

public class CirrusActivity extends AbstractAsyncTendrilActivity 
    implements ActionBar.TabListener { 

    private LinearLayout costLayout;
    private LinearLayout consumptionLayout;
    private LinearLayout thermostatLayout;

    private ActionBar.Tab costTab;
    private ActionBar.Tab consumptionTab;
    private ActionBar.Tab thermostatTab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Grab layouts
        setContentView(R.layout.cirrus_all_layout);
        costLayout = (LinearLayout) findViewById(R.id.cost);
        consumptionLayout = (LinearLayout) findViewById(R.id.consumption);
        thermostatLayout = (LinearLayout) findViewById(R.id.thermostat);
        
        // Setup actionbar
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_TABS);

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


        // Set Consumption Layout as default
        consumptionTab.select();
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

        // Determine which layout to make visible
        if(tab.equals(costTab))
            costLayout.setVisibility(0);
        else if(tab.equals(consumptionTab))
            consumptionLayout.setVisibility(0);
        else if(tab.equals(thermostatTab))
            thermostatLayout.setVisibility(0);
    }

    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
        // Stop any async tasks.... If we can even do that
    }

}
