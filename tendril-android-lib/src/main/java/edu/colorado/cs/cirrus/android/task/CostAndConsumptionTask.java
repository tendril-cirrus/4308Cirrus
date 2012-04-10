package edu.colorado.cs.cirrus.android.task;

import org.joda.time.DateTime;

import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.CostAndConsumption;
import edu.colorado.cs.cirrus.domain.model.Devices;
import edu.colorado.cs.cirrus.domain.model.User;

import android.os.AsyncTask;

public class CostAndConsumptionTask extends AsyncTask<TendrilTemplate, Void, CostAndConsumption> {

    @Override
    protected CostAndConsumption doInBackground(TendrilTemplate... params) {
        try {
            TendrilTemplate tendril = TendrilTemplate.get();
            if (tendril.isConnected())
                return tendril.fetchCostAndConsumptionRange(new DateTime("2011-01-01T00:00:00-07:00"),
                        new DateTime("2011-12-31T00:00:00-07:00"));

        }
        catch (Exception e) {
            e.printStackTrace();
            // Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }
}
