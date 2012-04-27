package edu.colorado.cs.cirrus.android;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import edu.colorado.cs.cirrus.domain.model.PricingProgram;

public class PricingProgramActivity extends AbstractAsyncTendrilActivity {
    protected static final String TAG = PricingProgramActivity.class.getSimpleName();

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendril_pricingprogram_layout);

    }

    @Override
    public void onStart() {
        super.onStart();

        PricingProgram program = null;
        try {
            this.showLoadingProgressDialog();
            program = tendril.fetchPricingProgram();

            TextView programName = (TextView) findViewById(R.id.pricingprogram_name);
            programName.setText(program.getName());

            TextView programDescription = (TextView) findViewById(R.id.pricingprogram_description);
            programDescription.setText(program.getDescription());

            TextView programSchedule = (TextView) findViewById(R.id.pricingprogram_schedule);
            programSchedule.setText(program.getSchedules().toString());

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            this.dismissProgressDialog();
        }
        System.err.println(program);
    }

}
