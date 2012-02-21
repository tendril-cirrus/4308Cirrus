package edu.colorado.cs.cirrus.android;

import android.app.Application;

public class TendrilApplication extends Application {
	private static TendrilTemplate tendril;

	public TendrilTemplate getTendril() {
		if (tendril == null)
			tendril = new TendrilTemplate("csci4138@tendrilinc.com", "password");
		return tendril;
	}
}
