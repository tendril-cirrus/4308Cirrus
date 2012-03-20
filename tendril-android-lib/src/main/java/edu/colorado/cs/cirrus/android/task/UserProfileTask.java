package edu.colorado.cs.cirrus.android.task;

import android.os.AsyncTask;
import edu.colorado.cs.cirrus.android.TendrilTemplate;
import edu.colorado.cs.cirrus.domain.model.UserProfile;

public class UserProfileTask extends AsyncTask<TendrilTemplate, Void, UserProfile> {
	private Exception ex;
	
	@Override
	protected UserProfile doInBackground(TendrilTemplate... params) {

		TendrilTemplate tendril = TendrilTemplate.get();
		try{
			if (tendril.isConnected()){
				return tendril.fetchUserProfile();
			}
		}catch(Exception e){
			ex=e;//save the exception & we will do something with it in onPostExecute
		}
		
		//System.err.println("UserProfileTask returning NULL (not logged in)!");
		return null;
	}
	
	@Override
	protected void onPostExecute(UserProfile profile){
		if(profile == null){
			profile=new UserProfile();//make an empty profile to hold the exception
		}
		
		profile.setException(ex);//even if ex is null, we still set it
	}
}
