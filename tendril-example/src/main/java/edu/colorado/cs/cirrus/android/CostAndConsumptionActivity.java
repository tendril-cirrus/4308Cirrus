package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.widget.TextView;
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
		setContentView(R.layout.tendril_generic_text_layout);

	}

	@Override
	public void onStart() {
		
		
		super.onStart();

		
		CostAndConsumption program = null;
		try {
			program = (new CostAndConsumptionTask()).execute(tendril).get();
			TextView textView = (TextView) findViewById(R.id.textView1);
			
			
			textView.setText(program.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String profile = new UserProfileTask().execute("").get();
		System.err.println(program);

		// String profile = task.execute();

	}

}
