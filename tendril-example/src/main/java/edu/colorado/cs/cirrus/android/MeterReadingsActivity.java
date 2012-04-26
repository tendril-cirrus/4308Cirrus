package edu.colorado.cs.cirrus.android;

import org.joda.time.DateTime;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.MeterReadings;

public class MeterReadingsActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = MeterReadingsActivity.class.getSimpleName();

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_meter_reading_layout);

    }

    @Override
    public void onStart() {

        super.onStart();

        MeterReadings meterReadings = null;
        try {
            // meterReading = (new MeterReadingTask()).execute(tendril).get();
            // meterReadings = tendril.asyncGetMeterReadings();
            this.showLoadingProgressDialog();
            meterReadings = tendril.fetchMeterReadingsRange(new DateTime("2012-03-01T00:00:00-07:00"),
                    (new DateTime()).minusDays(1));

            TextView meterReadingsData = (TextView) findViewById(R.id.textView1);
            TextView customerAgreement = (TextView) findViewById(R.id.meter_reading_agreement);
            TextView meterAsset = (TextView) findViewById(R.id.meter_asset);

            customerAgreement.setText(meterReadings.getMeterReading().getCustomerAgreement().getmRID());
            meterAsset.setText(meterReadings.getMeterReading().getMeterAsset().getmRID());
            meterReadingsData.setText(meterReadings.getMeterReading().getReadings().toString());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        // String profile = new UserProfileTask().execute("").get();
        System.err.println(meterReadings);

        // String profile = task.execute();

    }

}
