package cx.it.cirrus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.util.Log;

import org.json.JSONArray;
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


public class ViewPricingSchedule extends Activity {
	private static final String url = "https://dev-program.tendrildemo.com/api/rest/pricing/schedule;account=Jenkins;from=2010-01-01T00:00:00-0000;to=2010-01-02T00:00:00-0000";
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pricing_schedule);
	}
	

	private void updateMeterConsumption() throws JSONException {

		String response = "";
		String line = "";
		HttpsURLConnection c = null;
		try {
			URL u = new URL(url);

			c = (HttpsURLConnection) u.openConnection();

			c.setRequestProperty("Emsauthtoken",
					"jason@tendrilinc.com:password");
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
			Log.e(this.getLocalClassName(),
					"MalformedURLException  " + e.toString());
		} catch (IOException e) {
			Log.e(this.getLocalClassName(), "IOException   " + e.toString());
			e.printStackTrace();
		} finally {
			if (c != null)
				c.disconnect();
		}
		
		JSONObject j = new JSONObject(response);
		TextView v = (TextView) findViewById(R.id.textView1);
		
		JSONArray pricing = j.getJSONObject("effectivePriceRecords").getJSONArray("effectivePriceRecord");
		String text = "";
		String paragraph = "";
		for(int i = 0; i < (j.length()-1); i++){
			text =(((JSONObject) pricing.get(i)).get("programName").toString()+
				"\n"+((JSONObject) pricing.get(i)).get("programDescription").toString()+
				"\n"+ "Energy Price: "+((JSONObject) pricing.get(i)).get("energyPrice").toString()+
				"\n"+ "Delivery Charge : "+((JSONObject) pricing.get(i)).get("deliveryCharge").toString()+
				"\n"+ "Effective Date : "+((JSONObject) pricing.get(i)).get("effectiveDate").toString()+
				"\n"+ "End Date: "+((JSONObject) pricing.get(i)).get("endDate").toString()+ "\n"+"\n"
				);
			paragraph +=text;
		}
		v.setText(paragraph);
	}
		

	public void onStart() {
		super.onStart();
		try {
			updateMeterConsumption();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

