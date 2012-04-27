package edu.colorado.cs.cirrus.android;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

import edu.colorado.cs.cirrus.domain.intf.ITendril;

public abstract class AbstractAsyncTendrilActivity extends SherlockActivity implements AsyncActivity {

    protected static final String TAG = AbstractAsyncTendrilActivity.class.getSimpleName();

    private ProgressDialog progressDialog;

    private boolean destroyed = false;

    protected ITendril tendril;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.tendril = TendrilTemplate.get();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyed = true;
    }

    public void showLoadingProgressDialog() {
        this.showProgressDialog("Loading. Please wait...");
    }

    public void showProgressDialog(CharSequence message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
        }

        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && !destroyed) {
            progressDialog.dismiss();
        }
    }

}
