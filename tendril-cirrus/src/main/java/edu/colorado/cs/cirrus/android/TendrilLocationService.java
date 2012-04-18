package edu.colorado.cs.cirrus.android;

import java.util.List;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
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
		// TODO Use intents to broadcast location information to do something useful
		// For now, just toast to know that it has been received
		
		String message = String.format("Longitude: %1$.6f \n Latitude: %2$.6f \n \n",
    			loc.getLongitude(), loc.getLatitude());
		//Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
		
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
