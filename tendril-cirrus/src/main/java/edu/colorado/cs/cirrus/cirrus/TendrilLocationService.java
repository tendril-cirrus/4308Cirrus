package edu.colorado.cs.cirrus.cirrus;

import java.util.List;
import edu.colorado.cs.cirrus.android.*;

import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.intf.ITendril;
import edu.colorado.cs.cirrus.domain.model.SetThermostatDataRequest;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
 
public class TendrilLocationService extends Service implements LocationListener {
	
	private LocationManager manager = null;
    private static final int gpsMinTime = 600000; //10 minutes 
    private static final int gpsMinDistance = 0;

    public int onStartCommand(Intent intent, int flags, int startId) {
        startLocationService();
        return Service.START_STICKY;
    }
    
    private void startLocationService(){
        if (manager == null)
        {
                manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }
        
        final Criteria criteria = new Criteria();
        
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        
        final String bestProvider = manager.getBestProvider(criteria, true);
        
        if (bestProvider != null && bestProvider.length() > 0)
        {
                manager.requestLocationUpdates(bestProvider, gpsMinTime,gpsMinDistance, this);
        }
        else
        {
                final List<String> providers = manager.getProviders(true);
                
                for (final String provider : providers)
                {
                        manager.requestLocationUpdates(provider, gpsMinTime, gpsMinDistance, this);
                }
        }
    }
	
	public void onLocationChanged(Location loc) {
		Location home = new Location(manager.GPS_PROVIDER);
		PreferenceUtils prefs = new PreferenceUtils(getApplicationContext());

		home.setLatitude(prefs.getHomeLatitude());
		home.setLongitude(prefs.getHomeLongitude());
		
		//Need to see if the app is in the foreground
		ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);;
		Boolean appOpen = false;
		List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
		for(RunningAppProcessInfo appProcess : appProcesses){
		    if(appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND  && appProcess.processName.equals("edu.colorado.cs.cirrus.cirrus")){
		    	appOpen = true;
		    }
		}
		
		//If the app isn't open, set the thermostat to either home temp or away temp
		if(appOpen == false && prefs.getSmartHeat()){
			//Meters*0.0006214 to get miles
			if(loc.distanceTo(home)*0.0006214 > prefs.getGpsRadius()){
					try{
						TendrilTemplate.get().useAccessToken(prefs.getAccessToken());
						TendrilTemplate.get().setTstatSetpoint(prefs.getAwayTemp());
					}
					catch(TendrilException e){
						Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
						e.printStackTrace();	
	    			}
			}
			else{
					try{
						TendrilTemplate.get().useAccessToken(prefs.getAccessToken());
						TendrilTemplate.get().setTstatSetpoint(prefs.getHomeTemp());
					}
					catch(TendrilException e){
						Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
						e.printStackTrace();	
					}
			}
		}
		
	}


	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
