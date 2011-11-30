package cx.it.cirrus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TendrilManager extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		View currentMeterReading = findViewById(R.id.current_meter_reading);
		currentMeterReading.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.current_meter_reading:
			startActivity(new Intent(this, ViewCurrentMeterReading.class));
			break;
		}

	}

}