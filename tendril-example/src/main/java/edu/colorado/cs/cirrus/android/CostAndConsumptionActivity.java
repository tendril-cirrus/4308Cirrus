package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.android.task.PricingProgramTask;
import edu.colorado.cs.cirrus.android.task.CostAndConsumptionTask;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;

public class CostAndConsumptionActivity extends AbstractAsyncTendrilActivity {
	protected static final String TAG = CostAndConsumptionActivity.class
			.getSimpleName();

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tendril_cost_consumption_layout);

	}

	@Override
	public void onStart() {
		
		
		super.onStart();

		
		CostAndConsumption program = null;
		try {
			//program = (new CostAndConsumptionTask()).execute(tendril).get();
			//program=tendril.asyncGetCostAndConsumption();
			this.showLoadingProgressDialog();
			program=tendril.fetchCostAndConsumptionRange(new DateTime("2011-01-01T00:00:00-07:00"),
					new DateTime("2011-12-31T00:00:00-07:00"));
			this.dismissProgressDialog();
			
			TextView fromDateView = (TextView) findViewById(R.id.from_date);
			TextView toDateView = (TextView) findViewById(R.id.to_date);
			TextView costView = (TextView) findViewById(R.id.cost);
			TextView consumptionView = (TextView) findViewById(R.id.consumption);
			TextView consumptionData = (TextView) findViewById(R.id.textView1);

			toDateView.setText(program.getToDate());
			fromDateView.setText(program.getFromDate());
			Float costFloat = program.getCost();
			costView.setText(costFloat.toString());
			Float consumptionFloat = program.getConsumption();
			consumptionView.setText(consumptionFloat.toString());
			consumptionData.setText(program.getComponentList().toString());

			
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
		}finally{
			this.dismissProgressDialog();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(program);

		// String profile = task.execute();

	}

}
