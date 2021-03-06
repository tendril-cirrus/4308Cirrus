package edu.colorado.cs.cirrus.cirrus;


import edu.colorado.cs.cirrus.cirrus.R;

import edu.colorado.cs.cirrus.android.*;
import android.content.Intent;

import android.view.KeyEvent;

import android.view.View.OnClickListener;

import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import android.widget.TextView.OnEditorActionListener;

import edu.colorado.cs.cirrus.domain.TendrilException;

//import edu.colorado.cs.cirrus.domain.intf.ITendril;

public class TendrilActivity extends AbstractAsyncTendrilActivity {

    private String accessToken;
    private LinearLayout loginMenu;
    private LinearLayout mainMenu;


    private Button loginSubmitButton;
    private Button loginCancelButton;;
    private Button loginButton;
    private Button aboutButton;

    private EditText emailInput;
    private EditText passwordInput;

    private simpleListener mySimpleListener = new simpleListener();

    private PreferenceUtils cirrusPrefs;

    protected static final String TAG = TendrilActivity.class.getSimpleName();

    /**
     * Called when the activity is first created.
     * 
     * @param savedInstanceState
     *            If the activity is being re-initialized after previously being
     *            shut down then this Bundle contains the data it most recently
     *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     *            is null.</b>
     * 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        setContentView(R.layout.tendril_activity_layout);
        // setContentView(R.layout.main);
        
        cirrusPrefs = new PreferenceUtils(this);
        
    }

    @Override
    public void onStart() {
        super.onStart();
        // TendrilTemplate tendril = ((TendrilApplication)
        // getApplication()).getTendril();

        // Grab layouts and buttons
        loginButton = (Button) findViewById(R.id.LoginButton);
        loginSubmitButton = (Button) findViewById(R.id.LoginSubmitButton);
        loginCancelButton = (Button) findViewById(R.id.LoginCancelButton);
        aboutButton = (Button) findViewById(R.id.AboutButton);
        

        loginMenu = (LinearLayout) findViewById(R.id.LoginMenu);
        mainMenu = (LinearLayout) findViewById(R.id.MainMenu);

        // Grab inputs
        emailInput = (EditText) findViewById(R.id.EmailInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        // Set onClickListeners
        loginButton.setOnClickListener(mySimpleListener);
        loginSubmitButton.setOnClickListener(mySimpleListener);
        loginCancelButton.setOnClickListener(mySimpleListener);
        aboutButton.setOnClickListener(mySimpleListener);

        // Set action for when enter is pressed on the passwordInput field
        passwordInput.setOnEditorActionListener(new myEditorActionListener()); 


    }

    @Override
    public void onResume() {
        super.onResume();
        tendril = TendrilTemplate.get();
        // Recover our accessToken if set, or null if not set
        accessToken = cirrusPrefs.getAccessToken();

        if (accessToken == null) {
            // Show login Menu
            // 8 visibility = gone
            // 4 visibility = invisible
            // 0 visibility = visible
            loginMenu.setVisibility(0);
            mainMenu.setVisibility(8);

        } else {
            Intent intent = new Intent(this,
                    CirrusActivity.class);
            startActivityForResult(intent, 0);
            
//            Intent usageIntent = new Intent(this,
//                    UsageActivity.class);
//            startActivityForResult(usageIntent, 0);

        }

    }

    private class simpleListener implements OnClickListener {
        // 8 visibility = gone
        // 4 visibility = invisible
        // 0 visibility = visible
        public void onClick(View v) {
            if (v.equals(loginSubmitButton)) {
                loginClicked(v);
            }
            else if(v.equals(loginCancelButton)){
                //Hide loginMenu
                loginMenu.setVisibility(8);
                //Show mainMenu
                mainMenu.setVisibility(0);
            }
            else if(v.equals(loginButton)){
                //Hide mainMenu
                mainMenu.setVisibility(8);
                //Show loginMenu
                loginMenu.setVisibility(0);
            }
            else if (v.equals(aboutButton)) {
                Intent aboutIntent = new Intent(v.getContext(),
                        AboutActivity.class);
                startActivityForResult(aboutIntent, 0);
            }

        }

    }

    // What to do on login
    private void loginClicked(View v) {
        try {
            showLoadingProgressDialog();
            accessToken = tendril.logIn(emailInput.getText().toString(),
                    passwordInput.getText().toString());

            // Save accessToken
            cirrusPrefs.setAccessToken(accessToken);
           
            Intent intent = new Intent(this,
                    CirrusActivity.class);
            startActivityForResult(intent, 0);

        } catch (TendrilAndroidException e) {
        	String s=e.toString();
        	if(e.getStatusCode() == 403){//forbidden: in this case it means bad user/password
        		ToastFactory.showToast(v.getContext(), "Invalid user or password. Please try again.");
        	}
        	//the exception also has some JSON strings in the ErrorResponse (not deserialized),
        	//but it will always tell us invalid user/pass, so deserializing is not worth it
        	//the 403 is the only error code for which we need to do something special
            ToastFactory.showToast(v.getContext(), s);
        } catch(TendrilException e){
        	ToastFactory.showToast(v.getContext(), e.toString());
    	}finally {
            dismissProgressDialog();
        }
    }

    // What to do for actionGo
    private class myEditorActionListener implements OnEditorActionListener {
        public boolean onEditorAction(TextView v, int actionId,
                KeyEvent event ) {

            if (actionId == EditorInfo.IME_NULL) {
                mySimpleListener.onClick(loginSubmitButton);
            }
            return false;
        }

    }

}
