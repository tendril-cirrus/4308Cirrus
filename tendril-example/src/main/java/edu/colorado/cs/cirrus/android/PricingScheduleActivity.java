package edu.colorado.cs.cirrus.android;

import org.joda.time.DateTime;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;

public class PricingScheduleActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = PricingScheduleActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_pricingschedule_layout);
    }

    @Override
    public void onStart() {
        super.onStart();

        PricingSchedule schedule = null;
        try {
            DateTime startDate = new DateTime().withDate(2011, 3, 1).withTimeAtStartOfDay();
            DateTime endDate = new DateTime().withDate(2011, 3, 31).withTimeAtStartOfDay();

            this.showLoadingProgressDialog();
            schedule = tendril.fetchPricingSchedule(startDate, endDate);

            TextView test = (TextView) findViewById(R.id.textView1);
            TextView accountID = (TextView) findViewById(R.id.pricingschedule_accountid);
            TextView effectiveDate = (TextView) findViewById(R.id.pricingschedule_effective_date);
            TextView programName = (TextView) findViewById(R.id.pricingschedule_programname);
            TextView rateKey = (TextView) findViewById(R.id.pricingschedule_rate_key);
            TextView energyPrice = (TextView) findViewById(R.id.pricingschedule_energy_price);

            test.setText(schedule.getEffectivePriceRecords().toString());
            accountID.setText(schedule.getAccountId().toString());
            effectiveDate.setText(schedule.getEffectivePriceRecords().get(0).getEffectiveDate().toString());
            programName.setText(schedule.getEffectivePriceRecords().get(0).getProgramName().toString());
            rateKey.setText(schedule.getEffectivePriceRecords().get(0).getRateKey().toString());
            energyPrice.setText(schedule.getEffectivePriceRecords().get(0).getEnergyPrice().toString());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        System.err.println(schedule);
    }
}
