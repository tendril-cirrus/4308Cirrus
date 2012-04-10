package edu.colorado.cs.cirrus.android;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.PricingScheduleTask;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;
import edu.colorado.cs.cirrus.domain.model.PricingSchedule;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class PricingScheduleActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = PricingScheduleActivity.class
			.getSimpleName();

	
	private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;

    static final int DATE_DIALOG_ID = 0;
	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_pricingschedule_layout);

		// capture our View elements
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);

        // add a click listener to the button
        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplay();
		
        
        
	}

	@Override
	public void onStart() {
		super.onStart();

		PricingSchedule schedule = null;
		try {
			//schedule = (new PricingScheduleTask()).execute(tendril).get();
			
			DateTime startDate = new DateTime().withDate(2011, 3, 1).withTimeAtStartOfDay();
			DateTime endDate = new DateTime().withDate(2011, 3, 31).withTimeAtStartOfDay();
			
			
			schedule = tendril.fetchPricingSchedule(startDate, endDate);
			//schedule = tendril.asyncGetPricingSchedule();
			
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


		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(schedule);

		// String profile = task.execute();

	}
	
	 // updates the date in the TextView
    private void updateDisplay() {
        mDateDisplay.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
    }

 // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };
            
            @Override
            protected Dialog onCreateDialog(int id) {
                switch (id) {
                case DATE_DIALOG_ID:
                    return new DatePickerDialog(this,
                                mDateSetListener,
                                mYear, mMonth, mDay);
                }
                return null;
            }
    
}
