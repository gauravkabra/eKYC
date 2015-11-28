package com.shadows.alti.ekyc.Activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.shadows.alti.ekyc.R;

public class MainActivity extends AppCompatActivity {

    ViewGroup splashlogo;
    Context mContext;
    Button loginButton;
    EditText userID;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        /*to stop default animation*/
        getWindow().setWindowAnimations(0);

        setContentView(R.layout.activity_main);


        splashlogo = (ViewGroup) findViewById(R.id.splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                slideLogo();
                findViewById(R.id.language).setVisibility(View.VISIBLE);
            }
        }, 3000);

        userID = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.rst_submit_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "On click");

                    if (isNonEmpty()) {
                        // Start the AsyncTask to process the Json string in the background and then initialize the listview
                        Log.d("Login", "Start Processor");
                        EditText userId = (EditText) findViewById(R.id.user_id);
                        EditText password = (EditText) findViewById(R.id.password);

                        char[] passwordChars = new char[password.length()];
                        password.getText().getChars(0, password.length(), passwordChars, 0);




                    }
            }
        });


    }

    public void slideLogo() {

        AutoTransition smoothSlide = new AutoTransition();
        smoothSlide.setDuration(700);

        TransitionManager.beginDelayedTransition(splashlogo, smoothSlide);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        positionRules.setMargins(0, 40, 0, 0);
        positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        splashlogo.setLayoutParams(positionRules);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isNonEmpty() {
        /*get a reference to the EditText so that we can read in the value typed by the user*/
        EditText userID = (EditText) findViewById(R.id.user_id);
        EditText password = (EditText) findViewById(R.id.password);
        boolean isempty = true;

        /*Validating the User ID to be non-empty*/
        if (userID.getText().toString().length() == 0) {
            userID.setError(getString(R.string.userId));

            /*Setting the color of the EditText line as Red*/
            Drawable d = userID.getBackground();
            d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

            //setTheme(R.style.EditTextBottomLineError);

            isempty = false;

        }
        /*Validating the Password to be non-empty*/
        if (password.getText().toString().length() == 0) {
            password.setError(getString(R.string.pwdEmpty));

            /*Setting the color of the EditText line as Red*/
            Drawable d = password.getBackground();
            d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

            isempty = false;
        }
        return isempty;

    }
}
