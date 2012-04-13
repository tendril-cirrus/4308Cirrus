package edu.colorado.cs.cirrus.android;

import android.content.Context;

import android.widget.Toast;

public class ToastFactory {

    private static final int DURATION = Toast.LENGTH_SHORT;

    public static void showToast(Context context, String text) {

        Toast toast = Toast.makeText(context, text, DURATION);
        toast.show();
    }
}
