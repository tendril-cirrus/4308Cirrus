package cx.it.cirrus;

import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.androidplot.xy.XYPlot;

public class TendrilManager extends Activity implements Button.OnClickListener {
	private Button startDateButton;
	private Button endDateButton;
	private Button meterDataButton;
	private Button consumptionDataButton;
	private Button getMostRecentMeterReadingButton;
	private Button showPricingScheduleButton;
	static final int START_DATE_DIALOG_ID = 0;
	static final int END_DATE_DIALOG_ID = 1;
	static final int GET_MOST_RECENT_METER_READING_DIALOG_ID = 2;
	static final int SHOW_PRICING_SCHEDULE = 3;
	private Calendar startDateCalendar = Calendar.getInstance();
	private Calendar endDateCalendar = Calendar.getInstance();
	private XYPlot myTendrilPlot;

	// Listener for startDateButton
	private DatePickerDialog.OnDateSetListener startDateListener = new DatePickerDialog.OnDateSetListener() {
		// onDateSet method
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// Set startDateCalendar
			startDateCalendar.set(year, monthOfYear, dayOfMonth, 0, 0, 0);

		}
	};

	// Listener fo endDateButton
	private DatePickerDialog.OnDateSetListener endDateListener = new DatePickerDialog.OnDateSetListener() {
		// onDateSet method
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// Set endDateCalendar
			endDateCalendar.set(year, monthOfYear, dayOfMonth, 23, 59, 59);

		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Adding buttons to the layout
		startDateButton = (Button) findViewById(R.id.pickStartDate);
		// add a click listener to the button
		startDateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(START_DATE_DIALOG_ID);
			}
		});

		endDateButton = (Button) findViewById(R.id.pickEndDate);
		endDateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(END_DATE_DIALOG_ID);
			}
		});

		meterDataButton = (Button) findViewById(R.id.showMeterData);
		meterDataButton.setOnClickListener(this);

		consumptionDataButton = (Button) findViewById(R.id.showConsumptionData);
		consumptionDataButton.setOnClickListener(this);

		getMostRecentMeterReadingButton = (Button) findViewById(R.id.getMostRecentMeterReading);
		getMostRecentMeterReadingButton.setOnClickListener(this);

		showPricingScheduleButton = (Button) findViewById(R.id.pricing_schedule);
		showPricingScheduleButton.setOnClickListener(this);

		// Set plot stuff
		myTendrilPlot = (XYPlot) findViewById(R.id.myTendrilPlot);
		GraphUtils.initalizePlot(myTendrilPlot);

	}

	private void refreshMeterGraph() throws JSONException {

		if (!startDateCalendar.before(endDateCalendar)) {
			Toast.makeText(TendrilManager.this,
					"Start date must be before end date!!!", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		JSONObject meterReadings = MeterUtils.getDateRangeReadings(
				MeterUtils.METER_READINGS_BASE_URL,
				MeterUtils.calendarToURLString(startDateCalendar, true),
				MeterUtils.calendarToURLString(endDateCalendar, true));

		GraphUtils.setXYPlot(myTendrilPlot,
				MeterUtils.formatMeterData(meterReadings), "Meter Readings");

	}

	private void refreshConsumptionGraph() throws JSONException {

		if (!startDateCalendar.before(endDateCalendar)) {
			Toast.makeText(TendrilManager.this,
					"Start date must be before end date!!!", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		JSONObject consumptionReadings = MeterUtils.getDateRangeReadings(
				MeterUtils.CONSUMPTION_BASE_URL,
				MeterUtils.calendarToURLString(startDateCalendar, false),
				MeterUtils.calendarToURLString(endDateCalendar, false));

		GraphUtils.setXYPlot(myTendrilPlot,
				MeterUtils.formatConsumptionData(consumptionReadings),
				"Consumption Readings");

	}

	// Creating dialog
	@Override
	protected Dialog onCreateDialog(int id) {
		Calendar c = Calendar.getInstance();
		int cyear = c.get(Calendar.YEAR);
		int cmonth = c.get(Calendar.MONTH);
		int cday = c.get(Calendar.DAY_OF_MONTH);
		switch (id) {
		case START_DATE_DIALOG_ID:
			return new DatePickerDialog(this, startDateListener, cyear, cmonth,
					cday);
		case END_DATE_DIALOG_ID:
			return new DatePickerDialog(this, endDateListener, cyear, cmonth,
					cday);
		case GET_MOST_RECENT_METER_READING_DIALOG_ID:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Most Recent Meter Reading")
					.setMessage("Message")
					.setCancelable(true)
					.setNegativeButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			return builder.create();
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {

		case GET_MOST_RECENT_METER_READING_DIALOG_ID:
			System.out.println("onPrepareDialog");
			((AlertDialog) dialog).setMessage(MeterUtils
					.getMostRecentMeterReading());
		}

	};

	@Override
	public void onClick(View v) {
		try {
			if (v == startDateButton) {
				showDialog(START_DATE_DIALOG_ID);
			} else if (v == endDateButton) {
				showDialog(END_DATE_DIALOG_ID);
			} else if (v == meterDataButton)
				refreshMeterGraph();
			else if (v == consumptionDataButton)
				refreshConsumptionGraph();
			else if (v == getMostRecentMeterReadingButton) {
				showDialog(GET_MOST_RECENT_METER_READING_DIALOG_ID);
			} else if (v == showPricingScheduleButton) {
				startActivity(new Intent(this, ViewPricingSchedule.class));
			}
		} catch (JSONException j) {
			Log.e("JSONException:", j.toString());
		}

	}

}
