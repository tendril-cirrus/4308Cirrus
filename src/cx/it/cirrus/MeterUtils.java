package cx.it.cirrus;

import java.util.Calendar;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class MeterUtils {
    private static final String baseMeterReadURL = "https://dev-program.tendrildemo.com/api/rest/meter/read;account=Jenkins";
    private static String note_id = "";


    public static String getCurrentMeterReading(String username, String password) {

        String response = "";
        String line = "";
        HttpsURLConnection c = null;

        String currentMeterReadURL = baseMeterReadURL + ";from=2010-01-01T00:00:00-0000;limitToLatest=1";
        try {
            URL u = new URL(currentMeterReadURL);

            c = (HttpsURLConnection) u.openConnection();

            c.setRequestProperty("Emsauthtoken",
                    username+":"+password);
            c.setRequestProperty("Accept", "application/json");

            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    c.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response += line;
            }
        } catch (MalformedURLException e) {
            Log.e("MeterUtils ",
                    "MalformedURLException  " + e.toString());
        } catch (IOException e) {
            Log.e("MeterUtils ", "IOException   " + e.toString());
            e.printStackTrace();
        } finally {
            if (c != null)
                c.disconnect();
        }

        return response;
    }

    public static JSONObject getDateRangeMeterReading(String username, String password, Calendar start, Calendar end){
//        String startDateString = 

        return new JSONObject();

        
    }


}
