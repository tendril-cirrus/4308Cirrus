package edu.colorado.cs.cirrus.android;

import android.app.Activity;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private static final String ACCESSTOKEN = "accessToken";
    private static final String HOMELAT = "homeLatitude";
    private static final String HOMELONG = "homeLongitude";
    private static final String GPSFREQ = "gpsFrequency";
    private static final String SMARTHEAT = "smartHeat";
    private static final String HOMETEMP = "homeTemp";
    private static final String AWAYTEMP = "awayTemp";
    private static final String CUSTOMPREFS = "customCirrusPrefs";

    private static final int DEFAULT_AWAYTEMP = 60;
    private static final int DEFAULT_HOMETEMP = 70;

    private SharedPreferences customCirrusPrefs;
    private SharedPreferences.Editor editor;

    public PreferenceUtils(Context context){
        this.customCirrusPrefs = context.getSharedPreferences(CUSTOMPREFS, Activity.MODE_PRIVATE);
        this.editor = customCirrusPrefs.edit();
    }

    protected String getAccessToken() {
       return customCirrusPrefs.getString(ACCESSTOKEN, null); 
    }

    protected void setAccessToken(String accessToken) {
        editor.putString(ACCESSTOKEN, accessToken);
        editor.commit();
    }

    protected void removeAccessToken(){
        editor.remove(ACCESSTOKEN);
        editor.commit();
    }

    protected float getHomeLatitude() {
        return customCirrusPrefs.getFloat(HOMELAT, 0);
    }

    protected void setHomeLatitude(float latitude) {
        editor.putFloat(HOMELAT, latitude);
        editor.commit();
    }

    protected float getHomeLongitude() {
        return customCirrusPrefs.getFloat(HOMELONG, 0);
    }

    protected void setHomeLongitude(float longitude){
        editor.putFloat(HOMELONG, longitude);
        editor.commit();
    }

    protected int getAwayTemp(){
        return customCirrusPrefs.getInt(AWAYTEMP, DEFAULT_AWAYTEMP);
    }

    protected void setAwayTemp(int temperature){
        editor.putInt(AWAYTEMP, temperature); 
        editor.commit();
    }

    protected int getHomeTemp(){
        return customCirrusPrefs.getInt(HOMETEMP, DEFAULT_HOMETEMP);
    }

    protected void setHomeTemp(int temperature){
        editor.putInt(HOMETEMP, temperature); 
        editor.commit();
    }

    protected boolean getSmartHeat() {
        return customCirrusPrefs.getBoolean(SMARTHEAT, true);
    }

    protected void setSmartHeat(boolean enable) {
        editor.putBoolean(SMARTHEAT, enable);
        editor.commit();
    }


        

}
