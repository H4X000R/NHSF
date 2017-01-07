package com.divyeshbc.NHSF;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends BaseActivity {

    //private ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //Here setting a timer thread for displaying the Splash Screen
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    //Display the spalsh screen for 3000 milliseconds = 3 seconds
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //Once the 3 seconds are over the MainActivity will be started with the below Intent
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

        //splashImage = (ImageView) findViewById(R.id.splash);
        //splashImage.setImageResource(R.drawable.splash_screen);

        //Calling method nextActivity
        //nextActivity();

        //Logic for setting the colour of the status bar
        //If the Android OS on the phone is Android Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Set Status bar colour to Orange
            getWindow().setStatusBarColor(getResources().getColor(R.color.baseSecondaryBackgroundColour));

        }
    }

    @Override
    protected void onPause() {
        //This onPause method will help us achieve the destruction of the Splash Activity after
        //it is initially shown as we only want it to appear once, when the app is first started up.
        //The onPause method comes into play when the user leaves the activity.
        super.onPause();
        finish();
    }

    //This method will intent to the Main Activity Screen for the app after the Splash Screen
    //public void nextActivity(){

    //}
}
