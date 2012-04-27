package edu.colorado.cs.cirrus.android;

public interface AsyncActivity {

    void showLoadingProgressDialog();

    void showProgressDialog(CharSequence message);

    void dismissProgressDialog();

}
