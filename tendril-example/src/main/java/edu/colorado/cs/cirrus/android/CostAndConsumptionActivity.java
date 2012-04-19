package edu.colorado.cs.cirrus.android;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.CostAndConsumptionTask;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;

public class CostAndConsumptionActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = CostAndConsumptionActivity.class.getSimpleName();

    protected DateTime start = new DateTime().minusMonths(9);
    protected DateTime end = new DateTime().minusMonths(4);
    protected int limitToLatest = 20;
    private String resolution = CostAndConsumption.MONTHLY;

    private Button startPickDate;
    private int startYear;
    private int startMonth;
    private int startDay;

    private Button endPickDate;
    private int endYear;
    private int endMonth;
    private int endDay;

    static final int START_DATE_DIALOG_ID = 0;
    static final int END_DATE_DIALOG_ID = 1;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_cost_consumption_layout);
        // capture our View elements
        // startDateDisplay = (TextView) findViewById(R.id.startDateDisplay);
        startPickDate = (Button) findViewById(R.id.startPickDate);
        endPickDate = (Button) findViewById(R.id.endPickDate);

        // add a click listener to the buttons
        startPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(START_DATE_DIALOG_ID);
            }
        });

        endPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(END_DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        startYear = endYear = c.get(Calendar.YEAR);
        startMonth = endMonth = c.get(Calendar.MONTH);
        startDay = endDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplay();

    }

    @Override
    public void onStart() {

        super.onStart();

        CostAndConsumption results = null;
        try {
            this.showLoadingProgressDialog();
            results = tendril.fetchCostAndConsumption(resolution, start, end, limitToLatest);
            TextView consumptionData = (TextView) findViewById(R.id.results);
            consumptionData.setText(results.getComponentList().toString());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        // String profile = new UserProfileTask().execute("").get();
        System.err.println(results);

        // String profile = task.execute();

    }

    // updates the date in the TextView
    private void updateDisplay() {
        startPickDate.setText(new StringBuilder()
        // Month is 0 based so add 1
                .append(startMonth + 1).append("-").append(startDay).append("-").append(startYear).append(" "));

        endPickDate.setText(new StringBuilder()
        // Month is 0 based so add 1
                .append(endMonth + 1).append("-").append(endDay).append("-").append(endYear).append(" "));
    }

    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener startDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            start.withYear(year).withMonthOfYear(monthOfYear).withDayOfMonth(dayOfMonth).withTimeAtStartOfDay();
            startYear = year;
            startMonth = monthOfYear;
            startDay = dayOfMonth;
            updateDisplay();
        }
    };
    
    private DatePickerDialog.OnDateSetListener endDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            end.withYear(year).withMonthOfYear(monthOfYear).withDayOfMonth(dayOfMonth).withTimeAtStartOfDay().plusHours(24);
            endYear = year;
            endMonth = monthOfYear;
            endDay = dayOfMonth;
            updateDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case START_DATE_DIALOG_ID:
            return new DatePickerDialog(this, startDateSetListener, startYear, startMonth, startDay);
        case END_DATE_DIALOG_ID:
            return new DatePickerDialog(this, endDateSetListener, endYear, endMonth, endDay);
        }
        return null;
    }

   

   

}
